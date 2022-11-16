export class Editorial {
    id?: number;
    nombre: string;
    web_url: string;

    constructor(nombre: string, web_url: string){
        this.nombre = nombre;
        this.web_url = web_url;
    }

}
