export class Book {
    id?: number;
    nombre: string;
    descripcion: string;
    cantidad: number;
    editorial_id: number;
    imagen_url: string;
    dia_edicion: string;

    constructor(nombre: string, descripcion: string, cantidad: number, editorial_id: number, imagen_url: string, dia_edicion: string) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.editorial_id = editorial_id;
        this.imagen_url = imagen_url;
        this.dia_edicion = dia_edicion;
    }
}

