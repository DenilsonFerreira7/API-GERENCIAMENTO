### API REST DE CONTROLE DE MÁQUINAS PATRIMONIADA.

Nessa API é possível fazer cadastro de computadores patrimoniado, para ter o controle de entrada e saída, no laboratório de T.I. local de manutenção, usando o CRUD Básico.

Foi uma solução de organização criada, pois, no local fica varias maquinas parda esperando aquisição de peças por parte do usuário, podendo ficar até meses parados.


O maior objetivo dessa API é saber o paradeiro da maquina, total de maquinas parada, peças que faltam para aquisição e setores responsáveis, informações importantes  e ágeis  repasse para o setor de administração e até para o usuário final.


---
Para criação da API foram utilizados as seguintes ferramentas.


°  JAVA 17

° Intellij

° Swagger

° PostgreSQL

° Maven 

° Spring Boot 2.5.7 

------------------------------------------------------------

### Utilizando a ferramenta.

POST - Registra uma maquina no banco de dados.

PUT - Atualiza um dado existente.

GET - Consulta, informações.

DELETE - Deleta registro do banco de dados.

----
### Melhor forma de ultilizar.

Ao chegar equipamento no setor será feito a análise técnica e caso a maquina precise ficar aguardado aquisição  de algum hardware pelo usuário a mesma deve ser registrada no banco de dados com as seguintes informações.

° Patrimônio (ID).

° Chamado registrado.

° Peça para aquisição. 

° Setor responsavel.

° Data de registro é feita automaticamente.

Após devolução da maquina para o usuário o registro deve ser deletado.

---

### Interface.

Foi utilizado o _SWAGGER_, pois ele entrega uma interface básica pronta, porem se trata de uma interface inacessivel para usuarios padrões.
Futuramente será feito uma atualização integrando uma interface gráfica criada do zero com Angular, e sendo acessíveis para todos.
