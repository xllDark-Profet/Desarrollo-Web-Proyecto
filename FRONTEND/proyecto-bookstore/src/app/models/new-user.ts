export class NewUser {
    nombre: string;
    nombreUsuario: string;
    birth: string;
    password: string;

    constructor(nombre: string, nombreUsuario: string, birth: string, password: string) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.birth = birth;
        this.password = password;
    }
}