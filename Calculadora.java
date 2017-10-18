/*
  ______ __  __          __  __ ________   _____   ___
 |  ____|  \/  |   /\   |  \/  |  ____\ \ / / _ \ / _ \
 | |__  | \  / |  /  \  | \  / | |__   \ V / (_) | (_) |
 |  __| | |\/| | / /\ \ | |\/| |  __|   > < \__, |> _ <
 | |____| |  | |/ ____ \| |  | | |____ / . \  / /| (_) |
 |______|_|  |_/_/    \_\_|  |_|______/_/ \_\/_/  \___/

Emanuel Estrada Larios - A01633605
*/

public class Calculadora {

  private double a, b, r;
  private char operation;

  public Calculadora(){
    this.a = this.b = this.r = 0;
    this.operation = 'n';
  }

  public void setA(double a) {this.a = a;}
  public void setB(double b) {this.b = b;}
  public void setOperation(char o) {this.operation = o;}

  private double suma(){//double a, double b){
    return a + b;
  }

  private double resta(){//double a, double b){
    return a - b;
  }

  private double multiplica(){//double a, double b){
    return a * b;
  }

  private double divide(){//double a, double b){
    return a / b;
  }

  private double poder(){//double a, double b){
    return Math.pow(a,b);
  }

  public double calcula(){

    if(this.operation == 's')
      this.a = suma();
    else if(this.operation == 'r')
      this.a = resta();
    else if(this.operation == 'm')
      this.a = multiplica();
    else if(this.operation == 'd')
      this.a = divide();
    else if(this.operation == 'p')
      this.a = poder();
    // else
    //   this.a = this.b = 0;

    this.b = 0;
    return this.a;
  }

  public void limpiar(){
    this.a = this.b = 0;
  }

}
