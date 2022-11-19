/**
 * Esta clase representa al objeto usuario de la libreria 
 */
export class user {
    username:string;
    password:string;
    /**
     * Constructor de la clase
     * @param email 
     * @param password 
     */
    constructor(email: string, password:string){
        this.username=email;
        this.password=password;
    }
    /**
     * Metodo que obtiene el nombre de usuario
     * @returns nombre de usuario
     */
    getUsername():string{
        return this.username;
    }
    /**
     * Metodo que obtiene la contrasena de un usuario
     * @returns  contrasena
     */
    getPassword():string{
        return this.password;
    }
    /**
     * Metodo que modifica el usuario de una persona
     * @param email 
     */
    setUsername(email:string){
        this.username=email;
    }
    /**
     * Metodo que modifica la contrasena de una persona
     * @param password 
     */
    
    setPassword(password:string){
        this.password=password;
    }
}