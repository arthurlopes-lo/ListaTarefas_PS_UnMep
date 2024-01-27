# ListaTarefas_PS_UnMep
Projeto em Java desenvolvido no NetBeans. É uma aplicação de lista de tarefas que realiza operações básicas de CRUD.

OBS: Estas instruções são destinadas aos responsáveis pelo processo seletivo, driver de conexão e outros recursos serão enviados fora do GitHub 

#Segue as instruções para fazer a aplicação funcionar em uma máquina externa:

1. Faça o download do arquivo ZIP do projeto (repositório do GitHub), do arquivo do banco de dados e do driver JDBC MySQL (Enviado por email).
Transfira os arquivos baixados para a máquina.

2. Instale o WampServer64 (ou versão correspondente) na máquina, se ainda não estiver instalado.
Inicie o WampServer e verifique se o MySQL está em execução.
Abra o MySQL Workbench e importe o banco de dados a partir do arquivo disponibilizado.

3. Instale o NetBeans IDE na máquina de destino, caso não esteja instalado.
Abra o NetBeans e importe o projeto a partir do arquivo .zip.

4. Em "Libraries" selecione add jar/folder e adicione o driver de conexão que foi enviado.
Certifique-se de que o caminho do driver JDBC MySQL está configurado corretamente para sua máquina.
Verifique se as configurações de conexão com o banco de dados (URL, usuário, senha) estão atualizadas, caso tenha modificado algo no servidor, faça a alteração na classe ConexaoDAO em: String url = "jdbc:mysql://localhost:3306/lista_tarefas?user=root&password=";.

5. Execute o projeto.

Link de vídeo para melhor compreensão: https://youtu.be/XimIJKkoA40

#Funcionalidades Principais:

Adição de Tarefas (CREATE):
A aplicação permite aos usuários adicionar novas tarefas à lista. Um formulário simples coleta informações sobre a tarefa, como título, descrição, prazo e status.

Visualização da Lista de Tarefas (READ):
A lista de tarefas é exibida graficamente na interface (Jtable). 
Implementa funcionalidades de filtragem para que os usuários possam visualizar tarefas específicas. Capacidade de filtrar por prazo.

Atualização de Tarefas (UPDATE):
Os usuários têm a capacidade de editar informações de uma tarefa existente. Um formulário de edição permite a modificação do título, descrição ou data de conclusão da tarefa.

Exclusão de Tarefas (DELETE):
A aplicação suporta a exclusão de tarefas da lista. Isso é feito por meio de uma opção de exclusão que remove permanentemente a tarefa selecionada.

Interface Gráfica Amigável:
A interface gráfica é intuitiva e amigável, utilizando componentes gráficos do NetBeans, como botões, campos de texto e tabelas.

Tecnologias Utilizadas:

Java para a lógica do programa.
NetBeans IDE para o desenvolvimento.
Componentes gráficos do Swing para a interface do usuário.
Persistência de dados usando JDBC, arquivos ou outra solução adequada.
Esse projeto proporciona uma experiência prática na implementação de operações CRUD em Java, explorando também a inclusão de funcionalidades de filtragem para otimizar a visualização e gerenciamento da lista de tarefas.
