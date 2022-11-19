export class Persona {
    id?: number;
    nombre: string;
    apellido: string;
    cargo: string;
    nacimiento: string;
    usuario: string;
    contrasena: string;
    
    constructor(
        nombre: string,
        apellido: string,
        cargo: string,
        nacimiento: string,
        usuario: string,
        contrasena: string,
        ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.nacimiento = nacimiento;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}