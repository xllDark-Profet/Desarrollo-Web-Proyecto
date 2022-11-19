/**
 * Esta clase representa al objeto de perosna de la libreria 
 */
export class Person {
    id:number;
    name: string;
    surname:string;
    birth:string;
    charge:string;
    username:string;
    password:string;
    /**
     * Constructor de la clase
     * @param id 
     * @param name 
     * @param surname 
     * @param birth 
     * @param charge 
     * @param username 
     * @param password 
     */
    constructor(id:number, name: string, surname:string, birth:string,charge:string,username:string,password:string){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.birth=birth;
        this.charge=charge;
        this.username=username;
        this.password=password;
    }
    
    /**
     * Metodo que modifica el id
     * @param id 
     */
    setId(id: number){
        this.id=id;
    }
    /**
     * Metodo que modifica el nombre
     * @param name 
     */
    setName(name: string){
        this.name=name;
    }
    /**
     * Metodo que modifica el apellido
     * @param surname 
     */
    setSurname(surname: string){
        this.surname=surname;
    }
    /**
     * Metodo que modifica la fecha de nacimiento
     * @param birth 
     */
    setBirth(birth: string){
        this.birth=birth;
    }
    /**
     * Metodo que modifica el rol
     * @param charge 
     */
    setCharge(charge: string){
        this.charge=charge;
    }
    /**
     * Metodo que modifica el usuario
     * @param email 
     */
    setEmail(email: string){
        this.username=email;
    }
    /**
     * Metodo que verifica la contrasena
     * @param pass 
     */
    setPaswword(pass: string){
        this.password=pass;
    }

    /**
     * Metodo que obtiene el nombre
     * @returns nombre de la persona
     */
    getName():string{
        return this.name;
    }
    /**
     * Metodo que obtiene el rol 
     * @returns  rol de la persona
     */
    getCharge():string{
        return this.charge;
    }

    

}