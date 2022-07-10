# Calculadora_Forum



https://user-images.githubusercontent.com/64293419/178154706-1cc0a733-1f3e-4c1b-b905-495f54be31c4.mp4



A aplicação presente no link do repositório ClaudemirAlves/Calculadora_Forum foi desenvolvida utilizando-se da ferramenta Android Studio. Foram produzidos e editados, de maneira geral, três arquivos, que deram forma e funcionalidade ao aplicativo. São eles: activity_main.xml, themes.xml e MainActivity.java. 

Para o desenvolvimento da estrutura visual do aplicativo, ou seja, sua interface, foram inseridos no arquivo activity_main.xml várias estruturas do tipo “LinearLayout”. Elas foram as responsáveis por organizar os elementos na tela, servindo como “apoio” para que os elementos visuais fossem inseridos sobre elas. Elementos como “TextView” e “Button” proporcionaram as interações com o usuário.  

As configurações, ou atributos, dos elementos seriam um padrão já conhecido, semelhante ao desenvolvimento frontEnd Web, tais como configurações de largura e altera dos objetos (android:layout_width="match_parent", android:layout_height= "match_parent"), que receberam valores para que se assemelhassem aos atributos dos “pais” na maior parte dos casos. Atributos de estilização também foram usados, tais como os android:textStyle="bold" e o android:theme="@style/ThemeNumber Buttons.Calculadora". Os elementos “Button” receberam eventos, tais como o android:onClick="openParenthese", responsáveis pelas funcionalidades do aplicativo. 

O arquivo themes.xml foi utilizado para criar e editar as cores presentes no aplicativo. Essa utilização permitiu uma melhor organização da parte gráfica, fazendo-se uso de temas personalizados para elementos específicos, tais como o  <style name= "ThemeEqualsButtons.Calculadora" parent="Theme.MaterialComponents. DayNight.DarkActionBar">, que permitiu, por exemplo, configurar o botão “equals” especificamente com cores somente para ele. 

E o arquivo MainActivity.java recebeu toda a programação do aplicativo, com a criação dos métodos, variáveis e condicionais necessários para o funcionamento do app. Para cada botão de número e de operações matemáticas foram criados métodos. Os métodos para os botões foram configurados como void por não necessariamente precisarem retornar algum valor ou ação, e configurados como public por simples deliberação, permitindo o seu acesso por qualquer classe do sistema. Como parâmetro, todos os métodos para botões receberam “View v”, que é a única view existente na aplicação. 

Quanto a lógica de programação, ela foi desenvolvida para contornar o maior número possível de “erros de operação” do usuário. São exemplos os condicionais  if (str_point.contains(".")) e if (text2.endsWith(".") || text3.endsWith(".")), que alertam e coibem o usuário sobre a adição de ponto sem a adição de numeral após o ponto, ou o caso clássico de divisão por zero, ou também o condicional  if (parenthesesContent != ""), que, de acordo como foi feita a lógica do programa, permite verificar se há algum parêntese aberto no cálculo. 

As mensagens de sistema foram todas do tipo “Toast” São modelos práticos de alertar o usuário sem prejudicar o funcionamento do aplicativo. Permitem configurações como o tempo de aparição em tela e podem ser facilmente alteradas se for necessário. Alguns exemplos são “Toast.makeText(MainActivity.this, "Insira um número após o ponto", Toast.LENGTH_SHORT).show(); “, e “Toast.makeText (MainActivity.this, "Insira uma operação antes de abrir parênteses", Toast.LENGTH_SHORT).show();”, que deixam as mensagens por um período menor de tempo. 
