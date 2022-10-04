public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema Bancário");

        
        Cliente titanBr0202 = 
        new ClientePessoaFisica("Eduardo","Rua Mexico",20,"11111111",'m');
      
      if(titanBr0202.autenticar("11111112")){
        System.out.println("Autenticação valida");
      }
      else{
        System.out.println("Autenticação invalida");
      }
        
      
    }
}