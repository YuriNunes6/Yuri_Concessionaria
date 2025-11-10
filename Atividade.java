
import java.util.Scanner;

public class Atividade {

    public static class cadastroCliente {

        /*Criei uma classe para o cadastro de Clientes */
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
            if (senhaUsuario[posicaoCadastro].length() < 8) {

            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Sucesso! O cliente foi registrado no sistema.");
            posicaoCadastro++;
        }

        public cadastroCliente() {
            /*Construtor vazio para não precisar passar atributos dentro dos parâmetros na hora de instanciar as classes*/

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
            /*Construtor*/
            this.nomeFuncionario = nomeFuncionario;
            this.senhaFuncionario = senhaFuncionario;
        }

        public void exibirCadastro_Funcionario() {
            /*Método que solicita informações de cadastro ao funcionário */
            System.out.println("Informe o nome do funcionário abaixo:");
            nomeFuncionario[posicaoCadastro] = sc.nextLine();
            System.out.println("Insira uma senha abaixo:");
            senhaFuncionario[posicaoCadastro] = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Sucesso! O funcionário " + nomeFuncionario[posicaoCadastro] + " foi registrado.");
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
        String[] anoFabricacao = new String[100];
        boolean[] carroManutencao = new boolean[100];

        public cadastroCarro(String marcaCarro[], String modeloCarro[], String anoFabricacao[], boolean carroManutencao[]) {
            /*Construtor*/
            this.marcaCarro = marcaCarro;
            this.modeloCarro = modeloCarro;
            this.anoFabricacao = anoFabricacao;
            this.carroManutencao = carroManutencao;
        }

        public void exibirCadastro_Carro() {
            /*O método solicita informações básicas do carro a ser cadastrado */
            System.out.println("Informe a marca do veículo abaixo:");
            marcaCarro[posicaoCadastro] = sc.nextLine();
            System.out.println("Informe o modelo do veículo " + marcaCarro[posicaoCadastro] + " abaixo:");
            modeloCarro[posicaoCadastro] = sc.nextLine();
            System.out.println("Informe o ano de fabricação abaixo:");
            anoFabricacao[posicaoCadastro] = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Sucesso! O veículo " + modeloCarro[posicaoCadastro] + " " + marcaCarro[posicaoCadastro] + " foi registrado.");
            posicaoCadastro++;
        }

        public cadastroCarro() {

        }

    }

    public static class acoes {

        /*Menu de ações da concessionária*/
        int escolherAcao, escolhaVenda, escolhaManutencao;
        String nomeLogin, senhaLogin;
        boolean loginAprovado = false;

        /*Declaro variáveis para referenciar classes já existentes, elas serão utilizadas no menu*/
        cadastroCliente clientes;
        cadastroFuncionario funcionarios;
        cadastroCarro carros;

        Scanner sc = new Scanner(System.in);

        public acoes(int escolherAcao, cadastroCliente clientes, cadastroFuncionario funcionarios, cadastroCarro carros) {
            this.clientes = clientes;
            this.carros = carros;
            this.funcionarios = funcionarios;
        }

        public void exibirAcao() {
            /*Método que apresenta o menu ao usuário*/

            int loginInicio = 0;

            System.out.println("Insira seu nome abaixo");
            nomeLogin = sc.nextLine();
            System.out.println("Informe a senha abaixo");
            senhaLogin = sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            /*Condição que valida o nome e senha de cadastro do funcionário, ele é o agente intermediário entre
            as interações do cliente com a concessionária, portanto ele é o único que possui acesso a esse menu*/
            for (int i = 0; i < funcionarios.posicaoCadastro; i++) {
                if (nomeLogin.equals(funcionarios.nomeFuncionario[i])
                        && senhaLogin.equals(funcionarios.senhaFuncionario[i])) {
                    loginInicio++;
                    loginAprovado = true;
                    break;
                }
            }

            if (loginAprovado = true && loginInicio >= 1) {
                System.out.println("Sucesso! Login aprovado.");
                do {
                    System.out.println("1. Vender veículo");
                    System.out.println("2. Agendar manutenção de veículo");
                    System.out.println("3. Exibir clientes cadastrados");
                    System.out.println("4. Exibir funcionários cadastrados");
                    System.out.println("5. Exibir veículos cadastrados");
                    System.out.println("6. Sair");
                    escolherAcao = sc.nextInt();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sc.nextLine();

                    switch (escolherAcao) {
                        case 1:
                            System.out.println("Insira o ID referente ao carro a ser vendido:");
                            for (int i = 0; i < carros.posicaoCadastro; i++) {
                                System.out.println("ID: " + (i + 1) + " | " + carros.marcaCarro[i] + " " + carros.modeloCarro[i] + " - " + carros.anoFabricacao[i]);
                            }
                            escolhaVenda = sc.nextInt();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            if (escolhaVenda > 0 && escolhaVenda <= carros.posicaoCadastro) {
                                /*Aqui eu só relaciono a posição de cada array com o índice filtrado a partir
                                da escolha do usuário*/
                                for (int i = escolhaVenda; i < carros.posicaoCadastro; i++) {
                                    carros.marcaCarro[i - 1] = carros.marcaCarro[i];
                                    carros.modeloCarro[i - 1] = carros.modeloCarro[i];
                                    carros.anoFabricacao[i - 1] = carros.anoFabricacao[i];
                                }

                                /*De acordo com a escolha do usuário, o carro some da lista de registros e o tamanho do array 
                                diminui 1 unidade */
                                carros.marcaCarro[carros.posicaoCadastro] = "";
                                carros.modeloCarro[carros.posicaoCadastro] = "";
                                carros.anoFabricacao[carros.posicaoCadastro] = "";
                                carros.posicaoCadastro--;

                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                System.out.println("Venda realizada com sucesso!");
                                System.out.println("Veículos registrados no sistema:");

                                for (int i = 0; i < carros.posicaoCadastro; i++) {
                                    System.out.println("ID: " + (i + 1) + " | " + carros.marcaCarro[i] + " " + carros.modeloCarro[i] + " - " + carros.anoFabricacao[i]);
                                }

                            } else {
                                System.out.println("Desculpe, veículo não encontrado.");
                                System.out.println("Certifique-se que todas as informações referentes ao veículo estejam corretas.");
                            }
                            
                            System.out.println(" ");
                            break;

                        case 2:
                            System.out.println("Insira o ID do veículo solicitado para manutenção:");
                            for (int i = 0; i < carros.posicaoCadastro; i++) {
                                System.out.println("ID: " + (i + 1) + " | " + carros.marcaCarro[i] + " " + carros.modeloCarro[i] + " - " + carros.anoFabricacao[i]);
                            }
                            escolhaManutencao = sc.nextInt();
                            sc.nextLine();

                            /*Aqui utilizo uma booleana para identificar o status do carro, ("Disponível" ou "Em manutenção")*/
                            carros.carroManutencao[escolhaManutencao - 1] = false;
                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            /*Uma vez validado a escolha do veículo o array booleano torna-se True, e o veículo entra em manutenção*/
                            if (escolhaManutencao > 0 && escolhaManutencao <= carros.posicaoCadastro) {
                                carros.carroManutencao[escolhaManutencao - 1] = true;
                                System.out.println("Sucesso! O veículo " + carros.marcaCarro[escolhaManutencao - 1] + " "
                                        + carros.modeloCarro[escolhaManutencao - 1] + " está em manutenção.");
                            } else {
                                System.out.println("Desculpe, veículo não encontrado");
                                System.out.println("Certifique-se que as informações referentes ao veículo estejam corretas.");
                            }
                            System.out.println(" ");
                            break;

                        case 3:
                            /*Apresenta todos os clientes cadastrados no sistema*/
                            System.out.println("Clientes cadastrados:");
                            if (clientes.nomeUsuario != null) {
                                for (int i = 0; i < clientes.posicaoCadastro; i++) {
                                    System.out.println(clientes.nomeUsuario[i] + " - " + clientes.senhaUsuario[i]);
                                }
                            } else {
                                System.out.println("Nenhum usuário registrado.");
                            }
                            System.out.println(" ");
                            break;

                        case 4:
                            /*Apresenta todos os funcionários cadastrados no sistema*/
                            System.out.println("Funcionários cadastrados:");
                            for (int i = 0; i < funcionarios.posicaoCadastro; i++) {
                                System.out.println(funcionarios.nomeFuncionario[i] + " " + funcionarios.senhaFuncionario[i]);
                            }
                            System.out.println(" ");
                            break;

                        case 5:
                            /*Apresenta todos os carros registrados no sistema, juntamente com o status de disponibilidade*/
                            System.out.println("Carros cadastrados:");
                            for (int i = 0; i < carros.posicaoCadastro; i++) {
                                System.out.println(carros.marcaCarro[i] + " " + carros.modeloCarro[i] + " - "
                                        + carros.anoFabricacao[i] + " | " + (carros.carroManutencao[i] ? "Em manutenção" : "Disponível"));
                            }
                            System.out.println(" ");
                            break;
                    }
                } while (escolherAcao < 6);

            } else {
                System.out.println("Desculpe, as informações de login estão incorretas.");
                System.out.println("Certifique-se que todas as informações foram preenchidas corretamente.");
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
