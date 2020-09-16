# 📱 Aplicativo Marvel

O intuito do aplicativo é através da api da marvel, listar os personagens e suas respectivas descrições.

## 📄 Um pouco de teoria

### ♻️ Ciclo de vida de uma activity ou fragment

À medida que o usuário navega no aplicativo, sai dele e retorna a ele, as instâncias Activity no aplicativo transitam entre diferentes estados no ciclo de vida. A classe Activity fornece uma quantidade de callbacks que permite que a atividade saiba sobre a mudança do estado: informa a respeito da criação, interrupção ou retomada de uma atividade ou da destruição do processo em que ela reside por parte do sistema. Para navegar entre as fases do ciclo de vida da atividade, a classe “Activity” fornece um conjunto principal de seis callbacks: onCreate(), onStart(), onResume(), onPause(), onStop() e onDestroy(). Conforme a atividade entra em um novo estado, o sistema invoca cada um desses callbacks. À medida que o usuário começa a sair da atividade, o sistema chama métodos para eliminá-la. Em alguns casos, essa eliminação é somente parcial. A atividade ainda reside na memória, como quando o usuário alterna para outro aplicativo, e ainda pode voltar ao primeiro plano. Se o usuário retornar a essa atividade, a atividade será retomada de onde o usuário parou. Com algumas exceções, os aplicativos são impedidos de iniciar atividades quando executados em segundo plano.

### Sobre os métodos de um ciclo de vida
#### Activity
onCreate()
```
No método onCreate(), você executa a lógica básica de inicialização do aplicativo. Isso deve acontecer somente uma vez durante todo o período que a atividade durar.
```
onStart()
```
A chamada onStart() torna a atividade visível ao usuário, à medida que o aplicativo prepara a atividade para inserir o primeiro plano e se tornar interativa.
```
onResume()
```
Quando a atividade insere o estado "Retomado", ela vem para o primeiro plano e o sistema invoca o callback onResume(). É nesse estado que o aplicativo interage com o usuário. O app permanece nesse estado até que algo afete o foco do app.
```
onPause()
```
Use o método onPause() para pausar ou ajustar operações que não devem continuar (ou que precisem continuar com moderação) enquanto a Activity estiver no modo "Pausado" e aquelas que você espera retomar em breve.
```
onStop()
```
Quando a atividade não estiver mais visível ao usuário, ela inserirá o estado Interrompido e o sistema invocará o callback onStop(). No método onStop(), o aplicativo liberará ou ajustará recursos desnecessários enquanto o aplicativo não estiver visível ao usuário.
```
#### Fragments
onAttach()
```
Chamado quando o fragmento tiver sido associado à atividade (Activity é passado aqui).

```
onCreateView()
```
Chamado para criar a hierarquia de visualizações associada ao fragmento.

```
onActivityCreated()
```
Chamado quando o método onCreate() da atividade retornou.

```
onDestroyView()
```
Chamado quando a hierarquia de visualizações associada ao fragmento estiver sendo removida.
```
onDetach()
```
Chamado quando o fragmento estiver sendo desassociado da atividade.

```
### 💥 Activity e Fragments
#### Activity
A classe Activity é um componente crucial de um app para Android, e a maneira como as atividades são lançadas e reunidas é uma parte fundamental do modelo de aplicativo da plataforma. Diferentemente dos paradigmas de programação em que os apps são lançados com um método main(), o sistema Android inicia o código em uma instância Activity invocando métodos de callback que correspondem a estágios específicos do ciclo de vida.
#### Fragment
Um Fragment representa o comportamento ou uma parte da interface do usuário em um FragmentActivity. É possível combinar vários fragmentos em uma única atividade para criar uma IU de vários painéis e reutilizar um fragmento em diversas atividades. Você pode imaginar um fragmento como uma seção modular de uma atividade, que tem o próprio ciclo de vida, recebe os próprios eventos de entrada e que pode ser adicionada ou removida durante a execução da atividade (uma espécie de “subatividade” que pode ser reutilizada em diferentes atividades).
#### ❔ Quando usar ambos?
Os Fragments vieram para ajudar no desenvolvimento de interface para aplicativos maiores e representam um comportamento ou uma porção de interface e permite o reuso de código, tornando possível o desenvolvimento de interfaces mais dinâmicas, como por exemplo, mostrar duas classes de views diferentes em uma mesma tela e reaproveitar as views em telas diferentes.

### 🔨 Arquiteturas de desenvolvimento

#### MVP

##### Modelo (Model):
A Model caracteriza um conjunto de classes para descrever a lógica de negócios. Ela também descreve as regras de negócios para dados sobre como eles podem ser manipulados ou alterados.

##### O modo de exibição (View):
A View representa componentes da interface do usuário. Ela é responsável por exibir os dados recebidos do presenter como resultado. Ela também exibe os modelos na interface do usuário a partir do retorno do Presenter.

A View tende a ter o mínimo de regra de negócio possível. É comum falar que a View é "burra", pois ela apenas apresenta dados e recebe eventos de interação dos usuários, quem a controla e decide o que ela vai exibir é o Presenter.

##### Apresentador (Presenter):
O Presenter assume a responsabilidade de abordar todos os eventos da interface do usuário vindos da View. A View fornece os dados de entrada do usuário (input), em seguida, envia para o Presenter para filtrar esses dados (regra de negócio) e depois envia o resultado para a view. A View e o Presenter são totalmente distintos, mas se comunicam através de uma interface.

#### MVVM
##### Modelo (Model):
A Model caracteriza um conjunto de classes para descrever a lógica de negócios. Ela também descreve as regras de negócios para dados sobre como os dados podem ser manipulados ou alterados.

##### Visão (View):
A View representa componentes da interface do usuário. Ela também exibe os modelos na interface do usuário a partir do retorno da Presenter e da ViewModel. Assim como no MVP, a View aqui também tende a possuir o mínimo de regra de negócio possível, ela também é "burra", quem vai definir o que ela vai exibir é a ViewModel.

##### ViewModel:
A ViewModel é responsável por apresentar funções, métodos e comandos para manter o estado da View, operar a Model e ativar os eventos na View.

O ViewModel expõe fluxos de dados relevantes para o View. Mesmo neste caso, é a ponte entre o repositório e a View e contém toda a lógica de negócios.

Qual **EU** julgo melhor para aplicações android?
Ao meu ver a arquitetura MVVM se sobresai quando falamos sobre manutenção, testabilidade e extensabilidade pois é de facil alteração por causa da separação de diferentes tipos de códigos de maneira mais limpa o que ajuda a lançar novas versões rapidamente e a manter a agilidade. Outro fator é que todas as dependências internas e externas permanecerão no código que contém a lógica principal do aplicativo que você estava planejando testar deixando muito mais fácil a implementação de testes unitários. A arquitetura MVVM vem com o recurso no qual você pode adicionar novos trechos de código ou substituir os existentes que executam trabalhos semelhantes em alguns locais da estrutura da arquitetura.

## 🔇 Chega de teoria

### 🎨 Telas do Aplicativo
[![](https://i.imgur.com/ukGtH5H.png)](https://i.imgur.com/ukGtH5H.png)

### 💻 Como rodar o projeto no android studio
#### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas: [Git](https://git-scm.com/ "Git") e [Android Studio](https://developer.android.com/studio "Android Studio").

#### 🎲  Rodando o projeto
```
#1 - Clone este repositório
$ git clone https://github.com/ThyagoLuisBorges/Marvel-Api-android-app

#2 - Abra o projeto no Android Studio

#3 - Adicione "apply plugin: 'kotlin-kapt'" no gradle:app

#4 - Adicione as seguintes dependencias no gradle:app e sincronize

ext {
    retrofitVersion="2.9.0"
}

dependencies {   
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

    implementation 'androidx.core:core-ktx:1.3.1'
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.1'
    implementation 'androidx.recyclerview:recyclerview:1.1.0'

    implementation 'com.github.bumptech.glide:glide:4.11.0'
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

    implementation 'android.arch.lifecycle:extensions:1.1.1'

    implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"
    implementation "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    implementation 'androidx.cardview:cardview:1.0.0'

    kapt ("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
    implementation "com.squareup.moshi:moshi:1.9.3"

    testImplementation 'junit:junit:4.12'

    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

}
```
## 📝 Licença
Este projeto esta sobe a licença MIT. Veja a [LICENÇA](https://github.com/ThyagoLuisBorges/Ecoleta/blob/master/license "LICENÇA") para saber mais.

Feito com ❤️ por Thyago Luis Borges 👋🏽 Entre em contato!
