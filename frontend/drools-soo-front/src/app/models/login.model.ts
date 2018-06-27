export class LoginModel {

    private login: string;
    public get Login(): string {
        return this.login;
    }
    public set Login(value: string) {
        this.login = value;
    }

    private password: string;
    public get Password(): string {
        return this.password;
    }
    public set Password(value: string) {
        this.password = value;
    }
}
