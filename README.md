<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=E76F00&height=120&section=header"/>

# dio-banco-digital-oo <img width='50' heigth='50' src="https://static-00.iconduck.com/assets.00/java-icon-1511x2048-6ikx8301.png" />
### Introdução
#### A Programação Orientada a Objetos (POO) é um paradigma que organiza o software em torno de "objetos" — instâncias de classes que encapsulam dados e comportamentos. Para entender melhor esse paradigma, é fundamental conhecer quatro de seus principais pilares: abstração, encapsulamento, herança e polimorfismo. Abaixo, exploramos cada um desses conceitos, acompanhados de exemplos para facilitar a compreensão.

#

### 1 - Abstração
#### A abstração é a capacidade de focar nos aspectos essenciais de um sistema, ignorando detalhes não relevantes. Isso permite que as classes e objetos representem o mundo real de maneira simplificada, destacando apenas o que é necessário para o contexto.

#### _Exemplo:_
Em um sistema bancário, você pode abstrair uma "Conta" com atributos como número da conta, saldo e métodos como "depositar" e "sacar", sem se preocupar inicialmente com como esses métodos são implementados.

#

### 2 - Encapsulamento
#### Encapsulamento é o processo de esconder os detalhes internos de um objeto e expor apenas o que é necessário por meio de interfaces públicas (métodos). Esse princípio aumenta a segurança do sistema, evita alterações indevidas e facilita a manutenção e evolução.

#### _Exemplo:_
Imagine que um objeto "Conta" tenha um método sacar(). A implementação interna que verifica o saldo e processa a retirada fica oculta, enquanto o método sacar() expõe apenas a interface necessária para quem deseja sacar.

#

### 3 - Herança
#### Herança permite que uma nova classe seja criada com base em outra já existente, herdando seus atributos e comportamentos. Isso promove a reutilização de código e facilita a criação de estruturas mais organizadas.

#### _Exemplo:_
Suponha que você tenha uma classe "Conta". Uma classe "ContaPoupanca" pode herdar de "Conta" e adicionar novos métodos específicos, como o cálculo de juros, sem precisar reescrever todos os atributos e métodos comuns.

#

### 4 - Polimorfismo
#### Polimorfismo é a capacidade de objetos de diferentes classes serem tratados como instâncias de uma classe comum. Isso permite maior flexibilidade, pois podemos referenciar objetos de várias maneiras, mesmo que sejam de classes distintas, desde que compartilhem uma interface comum.

#### _Exemplo:_
Se você tiver uma função que recebe uma "Conta", poderá passar tanto uma instância de "ContaCorrente" quanto de "ContaPoupanca", e ambas serão tratadas como uma "Conta" durante a execução, desde que implementem os métodos necessários.

#

> ### Desafio Proposto
>“Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte cenário: um banco >oferece aos seus clientes dois tipos de contas (corrente e poupança), que possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”

#### Para concluir esse desafio, apliquei todos os conhecimentos adquiridos sobre Programação Orientada a Objetos, incluindo conceitos avançados, como o uso de `collections` para gerenciar algumas funcionalidades. Além disso, implementei o tratamento de exceções com blocos `try-catch` para lidar com possíveis erros de forma eficiente. Para melhorar a experiência do usuário, desenvolvi uma interface gráfica utilizando a biblioteca `Swing`.

#### O resultado foi uma aplicação robusta, com uma interface amigável e bem estruturada, você pode conferir clicando [aqui](edu/src). Este projeto me proporcionou um grande aprendizado e consolidou ainda mais meu entendimento sobre POO. Espero que gostem do resultado! Até mais!

---

### _Gostou do meu perfil? Você pode saber mais sobre mim em:_ &nbsp;&nbsp;[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaualimaq/)
### _Ou me contatar através do:_ &nbsp;&nbsp;[![Gmail](https://img.shields.io/badge/Gmail-333333?style=for-the-badge&logo=gmail&logoColor=red)](mailto:limakaua610@gmail.com)
### _Referências:_
[1] Repositório base DIO. Disponível em: https://github.com/falvojr/lab-banco-digital-oo
