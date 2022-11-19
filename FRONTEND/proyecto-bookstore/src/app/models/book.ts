/**
 * Esta clase representa al objeto de Libro de la libreria
 */
export class Book {
    /**Atributos de la clase */
    id?: number;
    nombre: string;
    descripcion: string;
    cantidad: number;
    editorial: string;
    imagen_url: string;
    dia_edicion: string;
    /**
     * Constructor de la clase
     * @param nombre 
     * @param descripcion 
     * @param cantidad 
     * @param editorial 
     * @param imagen_url 
     * @param dia_edicion 
     */
    constructor(nombre: string, descripcion: string, cantidad: number, editorial: string, imagen_url: string, dia_edicion: string) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.editorial = editorial;
        this.imagen_url = imagen_url;
        this.dia_edicion = dia_edicion;
    }
}

