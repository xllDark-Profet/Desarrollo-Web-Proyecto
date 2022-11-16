import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/service/editorial.service';

@Component({
  selector: 'app-nueva-editorial',
  templateUrl: './nueva-editorial.component.html',
  styleUrls: ['./nueva-editorial.component.css']
})
export class NuevaEditorialComponent implements OnInit {

  nombre = '';
  web_url = '';

  constructor(
    private editorialService: EditorialService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const editorial = new Editorial(this.nombre, this.web_url)
    this.editorialService.save(editorial).subscribe(
      data => {
        this.toastr.success('Editorial creada', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/editorial-table']);
      },
      err => {
        this.toastr.error(err.error.message, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/editorial-table']);
      }
    );
  }

}
