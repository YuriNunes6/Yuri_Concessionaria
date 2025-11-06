
import java.util.Scanner;

public class Atividade {

    public static class cadastroCliente {

        /*Crie uma classe para cadastro de Clientes */
        Scanner sc = new Scanner(System.in);
        int posicaoCadastro = 0;
        int tamanho = 100;
        String[] nomeUsuario = new String[tamanho];
        String[] senhaUsuario = new String[tamanho];

        public cadastroCliente(String nomeUsuario[], String senhaUsuario[]) {
            /*Construtor que inicializa os atributos para cada objeto criado posteriormente*/
            this.nomeUsuario = nomeUsuario;
            this.senhaUsuario = senhaUsuario;
        }

        public void exibirCadastro_Cliente() {
            /*Método criado para solicitar as informações de cadastro ao usuário final.*/
            System.out.println("Informe seu nome abaixo:");
            nomeUsuario[posicaoCadastro] = sc.nextLine();
            System.out.println("Insira uma senha abaixo:");
            senhaUsuario[posicaoCadastro] = sc.nextLine();
            System.out.println("Sucesso!");
            posicaoCadastro++;
        }

        public cadastroCliente() {
            /*Criei esse Construtor vazio intencionalmente para não precisar passar os arrays dentro do parâmetro na hora de instanciar as classes*/

        }
    }

    public static class cadastroFuncionario {

        /*Classe criada para cadastrar novos funcionários. */
        Scanner sc = new Scanner(System.in);
        int posicaoCadastro = 0;
        int tamanho = 100;
        String[] nomeFuncionario = new String[tamanho];
        String[] senhaFuncionario = new String[tamanho];

        public cadastroFuncionario(String nomeFuncionario[], String senhaFuncionario[]) {
            this.nomeFuncionario = nomeFuncionario;
            this.senhaFuncionario = senhaFuncionario;
        }

        public void exibirCadastro_Funcionario() {
            /*Método que solicita informações de cadastro do funcionário */
            System.out.println("Informe seu nome abaixo:");
            nomeFuncionario[posicaoCadastro] = sc.nextLine();
            System.out.println("Insira uma senha abaixo:");
            senhaFuncionario[posicaoCadastro] = sc.nextLine();
            System.out.println("Sucesso!");
            posicaoCadastro++;
        }

        public cadastroFuncionario() {
        }

    }

    public static class cadastroCarro {

        /*Classe criada para cadastrar novos veículos na concessionária */
        int posicaoCadastro = 0;
        Scanner sc = new Scanner(System.in);
        String[] marcaCarro = new String[100];
        String[] modeloCarro = new String[100];
        int[] anoFabricacao = new int[100];

        public cadastroCarro(String marcaCarro[], String modeloCarro[]) {
            /*Construtor */
            this.marcaCarro = marcaCarro;
            this.modeloCarro = modeloCarro;
        }

        public void exibirCadastro_Carro() {
            /*Solicita informações básicas do carro cadastrado */
            System.out.println("Informe a marca do veículo abaixo:");
            marcaCarro[posicaoCadastro] = sc.nextLine();
            System.out.println("Informe o modelo do veículo" + marcaCarro[posicaoCadastro] + " abaixo:");
            modeloCarro[posicaoCadastro] = sc.nextLine();
            System.out.println("Informe o ano de fabricação abaixo:");
            anoFabricacao[posicaoCadastro] = sc.nextInt();
            sc.nextLine();

            posicaoCadastro++;
        }

        public cadastroCarro() {
            /* */

        }

    }

    public static class acoes {

        /*Menu de ações da concessionária*/
        int escolherAcao, loginAprovado = 0;
        String nomeLogin, senhaLogin;

        /*Declaro variáveis para objetos de classes já existentes que serão utilizadas no menu*/
        cadastroCliente clientes;
        cadastroFuncionario funcionarios;
        cadastroCarro carros;

        Scanner sc = new Scanner(System.in);

        public acoes(int escolherAcao, cadastroCliente clientes, cadastroFuncionario funcionarios, cadastroCarro carros) {
            /*Construtor meio grande no parâmetro pois era necessário referenciar as outras classes que serão utilizadas aqui */
            this.escolherAcao = escolherAcao;
            this.clientes = clientes;
            this.carros = carros;
            this.funcionarios = funcionarios;

        }

        public void exibirAcao() {
            /*Método que mostra o menu*/

            System.out.println("Insira seu nome abaixo");
            nomeLogin = sc.nextLine();
            System.out.println("Informe a senha abaixo");
            senhaLogin = sc.nextLine();

            for (int i = 0; i < funcionarios.posicaoCadastro; i++) {
                if (nomeLogin.equals(funcionarios.nomeFuncionario[i])
                    && senhaLogin.equals(funcionarios.senhaFuncionario[i])) {

                    loginAprovado++;
                }
            }

            if (loginAprovado == 1) {
                do {
                    System.out.println("1. Vender veículo");
                    System.out.println("2. Agendar manutenção de veículo");
                    System.out.println("3. Exibir cadastros de clientes");
                    System.out.println("4. Exibir cadastros de funcionários");
                    System.out.println("5. Exibir veículos cadastrados");
                    System.out.println("6. Sair");
                    escolherAcao = sc.nextInt();

                    switch (escolherAcao) {
                        case 3:
                            System.out.println("Clientes cadastrados:");
                            /*Para chamar um atributo de outro escopo é necessário citar a variável declarada a ela (ali em cima)*/
                            for (int i = 0; i < clientes.posicaoCadastro; i++) {
                                System.out.println(clientes.nomeUsuario[i] + "" + clientes.senhaUsuario[i]);
                            }
                            break;
                        case 4:
                            System.out.println("Funcionários cadastrados:");
                            for (int i = 0; i < funcionarios.posicaoCadastro; i++) {
                                System.out.println(funcionarios.nomeFuncionario[i] + "" + funcionarios.senhaFuncionario[i]);
                            }
                            break;
                        case 5:
                            System.out.println("Carros cadastrados:");
                            for (int i = 0; i < carros.posicaoCadastro; i++) {
                                System.out.println(carros.marcaCarro[i] + "-" + carros.modeloCarro[i] + "-" + carros.anoFabricacao[i]);
                            }
                            break;
                    }
                } while (escolherAcao < 6);

            }
        }

        public acoes() {

        }
    }

    public static void main(String[] args) {
        int escolha;
        Scanner sc = new Scanner(System.in);
        /*Instanciando objetos de cada classe definida. */
        cadastroCliente c1 = new cadastroCliente();
        cadastroFuncionario cf = new cadastroFuncionario();
        cadastroCarro carros = new cadastroCarro();
        acoes acoes = new acoes(0, c1, cf, carros);

        do {

            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar funcionário");
            System.out.println("3. Cadastrar veículos");
            System.out.println("4. Ações");
            System.out.println("5. Sair");
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    c1.exibirCadastro_Cliente();
                    break;

                case 2:
                    cf.exibirCadastro_Funcionario();
                    break;

                case 3:
                    carros.exibirCadastro_Carro();
                    break;

                case 4:
                    acoes.exibirAcao();
                    break;

                case 5:
                    break;
            }
        } while (escolha < 5);
    }
}
