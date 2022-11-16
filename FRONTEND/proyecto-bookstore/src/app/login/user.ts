export class user {
    username:string;
    password:string;

    constructor(email: string, password:string){
        this.username=email;
        this.password=password;
    }

    getUsername():string{
        return this.username;
    }

    
    getPassword():string{
        return this.password;
    }

    setUsername(email:string){
        this.username=email;
    }

    
    setPassword(password:string){
        this.password=password;
    }
}