/**
 * Esta clase representa al objeto de Editoriald e la libreria
 */
export class Editorial {
    /**Atributos de la clase */
    id?: number;
    nombre: string;
    web_url: string;
    /**
     * Constructor de la clase
     * @param nombre 
     * @param web_url 
     */
    constructor(nombre: string, web_url: string){
        this.nombre = nombre;
        this.web_url = web_url;
    }

}
