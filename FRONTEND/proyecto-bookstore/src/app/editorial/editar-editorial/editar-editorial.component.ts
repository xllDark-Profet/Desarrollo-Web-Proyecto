import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/service/editorial.service';

@Component({
  selector: 'app-editar-editorial',
  templateUrl: './editar-editorial.component.html',
  styleUrls: ['./editar-editorial.component.css']
})
export class EditarEditorialComponent implements OnInit {

  editorial!: Editorial;

  constructor(
    private editorialService: EditorialService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.editorialService.editorialdetail(id).subscribe(
      data => {
        this.editorial = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/editorial-table']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.editorialService.update(id, this.editorial).subscribe(
      data => {
        this.toastr.success('Editorial Actualizada', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/editorial-table']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/editorial-table']);
      }
    );
  }

}
