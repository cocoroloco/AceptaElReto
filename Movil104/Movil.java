import java.util.Scanner;

/**
   * Movil
   */
public class Movil {
  int leftWeight;
  int leftDistance;
  Movil leftMovil;

  int rightWeight;
  int rightDistance;
  Movil rightMovil;

  boolean balanced=true;

  Scanner scanner = new Scanner(System.in);

  int lw,ld,rw,rd;

  public Movil(){}


  public Movil(int lw, int ld, int rw, int rd){

    this.leftWeight = lw;
    this.leftWeight = ld;

    this.rightWeight = rw;
    this.rightDistance = rd;

  }
  
  //Aquí se tienen que combinar la entrada por teclado y la creacion
  public void checkSubMoviles(Movil movile){
    //Poner la carga de datos desde entrada aqui
    System.out.println("Introduce los datos de los móviles en el formato 'lw ld rw rd' (deja una línea vacía para terminar):");
    String line = scanner.nextLine();
    if (line.isEmpty()) {
      
    }
    String[] parts = line.split(" ");
    if (parts.length != 4) {
      System.out.println("Entrada inválida. Introduce exactamente cuatro números.");
    }
    try {
      lw = Integer.parseInt(parts[0]);
      ld = Integer.parseInt(parts[1]);
      rw = Integer.parseInt(parts[2]);
      rd = Integer.parseInt(parts[3]);
    } catch (NumberFormatException e) {
      System.out.println("Entrada inválida. Asegúrate de introducir solo números.");
    }
    if(lw == 0 && ld == 0 && rw== 0 && rd==0){

    } else {
      if (movile.leftWeight != 0 && movile.rightWeight != 0) {
      this.leftWeight = lw;
      this.leftWeight = ld;
      this.rightWeight = rw;
      this.rightDistance = rd;

      this.calculateBalance();

    } else if(movile.leftWeight == 0){
      this.leftMovil = new Movil(lw, ld, rw, rd);

      checkSubMoviles(this.leftMovil);

    } else{
      this.rightMovil = new Movil(lw, ld, rw, rd);

      checkSubMoviles(this.rightMovil);

    }
    }
  }

  public void calculateBalance(){
    if (this.leftWeight * this.leftDistance != this.rightWeight * this.rightDistance) {
      this.balanced = false;
    }
  }


  public static void main(String[] args) {

   //Crear metodo crear Movil(La estructura completa) 

  
    Movil father = new Movil();
    father.checkSubMoviles(father);



    System.out.println("Hola");
  }
}

