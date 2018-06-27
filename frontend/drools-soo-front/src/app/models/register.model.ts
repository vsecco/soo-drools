export class RegisterModel {

    private name: string;
    public get Name(): string {
        return this.name;
    }
    public set Name(value: string) {
        this.name = value;
    }

    private cpf: string;
    public get Cpf(): string {
        return this.cpf;
    }
    public set Cpf(value: string) {
        this.cpf = value;
    }

    private birthday: Date;
    public get Birthday(): Date {
        return this.birthday;
    }
    public set Birthday(value: Date) {
        this.birthday = value;
    }

    private amount: string;
    public get Amount(): string {
        return this.amount;
    }
    public set Amount(value: string) {
        this.amount = value;
    }

    private civilStatus: string;
    public get CivilStatus(): string {
        return this.civilStatus;
    }
    public set CivilStatus(value: string) {
        this.civilStatus = value;
    }

    private password: string;
    public get Password(): string {
        return this.password;
    }
    public set Password(value: string) {
        this.password = value;
    }
}
