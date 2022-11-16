export class Person {
    id:number;
    name: string;
    surname:string;
    birth:string;
    charge:string;
    username:string;
    password:string;

    constructor(id:number, name: string, surname:string, birth:string,charge:string,username:string,password:string){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.birth=birth;
        this.charge=charge;
        this.username=username;
        this.password=password;
    }
    

    setId(id: number){
        this.id=id;
    }

    setName(name: string){
        this.name=name;
    }

    setSurname(surname: string){
        this.surname=surname;
    }

    setBirth(birth: string){
        this.birth=birth;
    }

    setCharge(charge: string){
        this.charge=charge;
    }

    setEmail(email: string){
        this.username=email;
    }

    setPaswword(pass: string){
        this.password=pass;
    }


    getName():string{
        return this.name;
    }

    getCharge():string{
        return this.charge;
    }

    

}