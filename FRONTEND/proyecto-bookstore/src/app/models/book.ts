

export class Book {
    id?: number;
    name: string;
    description: string;
    editorial_id: number;
    date_edition: string;
    image_url: string;
    quantify: string;

    constructor(name: string, description: string, editorial_id: number, date_edition: string, image_url: string, quantify: string){
        this.name = name;
        this.description = description;
        this.editorial_id = editorial_id;
        this.date_edition = date_edition;
        this.image_url = image_url;
        this.quantify = quantify;
    }
}

