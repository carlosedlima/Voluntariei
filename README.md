voluntariei
Descrição
O "voluntariei" é um aplicativo Android que conecta voluntários a oportunidades de voluntariado em sua comunidade. Ele utiliza a biblioteca Hilt para injeção de dependência e Retrofit para fazer requisições HTTP à API do aplicativo. O código é estruturado seguindo a arquitetura Data, Domínio e UI.

Estrutura do Projeto
O código fonte do aplicativo está organizado da seguinte forma:

data: Contém as classes responsáveis por obter e manipular os dados.

RetrofitEventoDataSource.kt
RetrofitHelpDataSource.kt
RetrofitOngDataSource.kt
RetrofitUsuarioDataSource.kt
di: Contém as classes de injeção de dependência.

DataSourceModule.kt: Configura a injeção de dependência para as fontes de dados.
Request.kt: Definição de um objeto de requisição HTTP.
domain: Contém as regras de negócio e lógica de aplicativo.

di: Configuração de injeção de dependência para os casos de uso.
DomainModule.kt
impl: Implementações dos casos de uso.
EventoUseCaseImpl.kt
HelpUseCaseImpl.kt
OngUseCaseImpl.kt
UserUseCaseImpl.kt
models: Classes de modelo de domínio.
Evento.kt
Help.kt
LoginRequest.kt
LoginResponse.kt
Notification.kt
ONG.kt
User.kt
usecase: Interfaces dos casos de uso.
EventoUseCase.kt
HelpUseCase.kt
OngUseCase.kt
UsuarioUseCase.kt
ui: Contém as classes responsáveis pela interface do usuário.

aboutapp: Sobre o aplicativo.
help: Ajuda.
home: Página inicial.
login: Página de login.
mydata: Meus dados.
profile: Perfil do usuário.
splashscreen: Tela de abertura.
utils: Classes utilitárias.

MainActivity.kt
MyApplication.kt
Instalação
