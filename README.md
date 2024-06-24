# Voluntariei

Voluntariei é um aplicativo Android que conecta voluntários a oportunidades de voluntariado em sua comunidade, facilitando o ganho de horas complementares.

## Descrição

O aplicativo Voluntariei permite que voluntários encontrem projetos de ONGs para participar, ajudando tanto as organizações quanto os voluntários a atingirem seus objetivos. O aplicativo utiliza uma arquitetura
baseada em MVVM e Clean Architecture, para garantir um código escalável e de fácil manutenção.

## Arquitetura

- **MVVM (Model-View-ViewModel)**: Facilita a separação de preocupações, tornando o código mais modular e testável.
- **Clean Architecture**: Promove a organização do código em camadas (Data, Domínio, UI), assegurando que cada camada tenha responsabilidades claras e bem definidas.

## Bibliotecas Utilizadas

- **Retrofit**: Utilizado para realizar requisições HTTP à API, garantindo a comunicação eficiente com os serviços web.
- **LiveData**: Utilizado para observar dados de forma reativa e responder a mudanças de estado na UI.
- **Dagger Hilt**: Utilizado para injeção de dependências, simplificando a gestão de dependências e melhorando a testabilidade do código.

## Estrutura do Projeto

- **Data**: Contém as implementações de repositórios, fontes de dados (API, banco de dados local) e modelos de dados.
- **Domínio**: Contém as interfaces de repositórios, casos de uso (use cases) e modelos de domínio.
- **UI**: Contém as atividades, fragmentos, view models e componentes de interface do usuário.

## Design

O design do aplicativo pode ser visualizado no [Figma](https://www.figma.com/design/l28ADtabwVVgKIyY2kTRAG/Voluntariei?m=dev&node-id=203-32&t=jX3lsWrwubg0zUMp-1).
## Api
Esse é o repositório da [API](https://github.com/carlosedlima/voluntariei-api).

https://github.com/carlosedlima/Voluntariei/assets/63886695/d6692404-f10d-459d-adb0-e1ae241fb220

