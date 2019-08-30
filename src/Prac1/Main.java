import java.util.Scanner;

public class Main {
    public static void main(String[] ARGS)

    {
    Scanner scanner = new Scanner(System.in);
System.out.println("elija una opcion");
System.out.println("1 fibo");
System.out.println("2 cubo");
System.out.println("3 primo");
int x=0;
x= scanner.nextInt();
if (x==1){
Fibonacci();

}
if(x==2){
    Cuadrado();
}
if (x==3);
    Primo();
}


public static void Primo()


    {

        Scanner obtenerNumero = new Scanner(System.in);

        int contador,I,numero;

 

        System.out.print("Ingresa un numero: ");

        numero = obtenerNumero.nextInt();

 

        contador = 0;

 

        for(I = 1; I <= numero; I++)

        {

            if((numero % I) == 0)

            {

                contador++;

            }

        }

 

        if(contador <= 2)

        {

            System.out.println("El numero es primo");

        }else{

            System.out.println("El numero no es primo");

        }

    }
public static void Fibonacci (){
    

int n = 0, t1 = 0, t2 = 1;
System.out.println("Cuantas posiciones desea mostrar en la serie?");

n = scanner.nextInt();
System.out.println("Hasta " + n + "posiciones: ");
while (int i = 1; i<=n; i++)
{

System.out.print(t1+" ");
int sum = t1 + t2;
t2 = sum;

}
}
}
