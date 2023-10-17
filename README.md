# SendMessageViewBinding
## Introdución
Es un proyecto de Android que manda un objeto Message con el contenido de un mensaje y Person con los datos del usuario, estos dos objetos se reciber en ViewMessageActivity.


Conceptos basicos:
- Crear diferentes clases 
- Utilizar recursos para cambiar colores, estilo y  cambiar texto
    - Cambiar el estilo de las letras
    - Cambiar el estilo de la aplicación
    - Hacer la aplicacion para dos idiomas
- Uso de binding
- Crear el evento OnClick()
- Serializar y parcelar el objeto Bundle
- Depurar el codigo
- Comprobar el ciclo de la vida
- Crear la interfaz orientacion horizontal
- Crear el menú (About us)

### Clases 
Tiene varias clases, como:

Person ue engloba la informacion de una persona en nuestra app 

Message que guarda el mensaje

La clase Person y Message implementan dos clases (implements Serializable, Parcelable )

AboutUs crea información de la aplicación y hereda de MaterialAboutActivity
clase MessageApplication que hereda de Aplicacion (extends Application)

SendMessageActivity que hereda de  AppCompatActivity, esta clase envia el mensaje
y la clase ViewActivity que hereda de AppCompatActivity también.

### Recursos de colores y strings
###### Colores:
```html
<resources>
      <color name="seed">#6750A4</color>
    <color name="md_theme_light_primary">#6750A4</color>
    <color name="md_theme_light_onPrimary">#FFFFFF</color>
    <color name="md_theme_light_primaryContainer">#CFB6F8</color>
    <color name="md_theme_light_onPrimaryContainer">#21005D</color>
    <color name="md_theme_light_secondary">#625B71</color>
    <color name="md_theme_light_onSecondary">#FFFFFF</color>
    <color name="md_theme_light_secondaryContainer">#D1B6FB</color>
</resources>
```
###### Dimensiones
Dimensiones para titulo de la aplicación (30sp)
```html
<resources>
    <dimen name="tvTitleMessage_textSize">30sp</dimen>
</resources>
```
###### Texto:
Es un recurso de strings para aplicacion en español
translatable = false significa que se queda igual para todos los idiomas, que no traduce
```html
<resources>
    <string name="app_name">SendMessage</string>
    <string name="tvTitleMessage">Escribe un Mensaje:</string>
    <string name="tvUserInfoText">Muestra la informacion del usuario:</string>
    <string name="tvMessageText">La informacion del mensaje:</string>
    <string name="menu_about">Personal Information:</string>
    <string name="menu_gh" translatable="false">GitHub</string>
    <string name="menu_nombre" translatable="false">Kateryna Nikitenko</string>
    <string name="menu_napp" translatable="false">Send Message</string>
    <string name="menu_nautor">Autor</string>
    <string name="menu_nmodulo">Alum. módulo DEINT</string>
</resources>
```
Y es un ejemplo de string para la aplicacion en ingles
```html
<resources>
    <string name="app_name">SendMessage</string>
    <string name="tvTitleMessage">Write a message:</string>
    <string name="tvUserInfoText">Show user information</string>
    <string name="tvMessageText">"The message information "</string>
    <string name="menu_about" translatable="false">About us</string>
    <string name="menu_nmodulo">Student module DEINT</string>
    <string name="menu_nautor">Author</string>
</resources>
```
También se puede cambiar el estilo de las letras, a la carpeta font añadir archivo .ttf y en activity:

`  <TextView android:fontFamily="@font/vanilla_demo"/>`
###### Tema
Es el estilo para modo claro, tambien hay otro archivo de themes.xml(night) para modo oscuro
```html
<resources>
    <style name="AppTheme" parent="Theme.Material3.Light">
        <item name="colorPrimary">@color/md_theme_light_primary</item>
        <item name="colorOnPrimary">@color/md_theme_light_onPrimary</item>
        <item name="colorSecondary">@color/md_theme_light_secondary</item>
        <item name="colorOnSecondary">@color/md_theme_light_background</item>
        <item name="colorTertiary">@color/md_theme_light_tertiary</item>
        <item name="colorOnTertiary">@color/md_theme_light_background</item>
    </style>
</resources>
```

### Crear binding y el evento OnClick()
*** Ejemplo ***
```html
 private ActivitySendMessageBinding binding;

 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //exprecion lambda para inplementar el evento OnClick()
        binding.fab.setOnClickListener(view -> {  sendMessage(); } );
    }
```

### Crear el menú (About us)
Es una clase para poner la información de la aplicación
```html
dependencies {
    implementation("com.github.daniel-stoneuk:material-about-library:3.1.2")
}
```
***Ejemplo***
```html
public class AboutActivity extends MaterialAboutActivity {
		 @NonNull
		 @Override
		 protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
 				 MaterialAboutCard.Builder card = new MaterialAboutCard.Builder();
 				 cardr.title(R.string.menu_nautor);
 			     cardr.addItem(new MaterialAboutActionItem.Builder()
      		    .text(R.string.menu_nombre)
       		   .subText(R.string.menu_nmodulo)
        		   .icon(R.drawable.ic_autor)
       		   .build());



 	   return new MaterialAboutList.Builder()
        	  .addCard(card.build())
         	 .build();
	 }
 }
```

### Ciclo de la vida
Comprobar el ciclo de vida se puede en el monitor LogCat
 ```html
protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
```
### La interfaz orientacion horizontal
En la carpeta layout hay que crear una activity (land)
En este ejemplo es activity_send_message.xml(land) y para esta activity creamos su interfaz en horizontal

## Screenshots

|                              |                              | 
| ---------------------------- | ---------------------------- | 
|![foto1](https://github.com/nikitenkokatya/SendMessageViewBinding/assets/145988774/aa64305f-2fb7-40fb-aa9f-2166e7ceb665) | ![foto2](https://github.com/nikitenkokatya/SendMessageViewBinding/assets/145988774/1186ede0-b928-4613-abe4-c50754366717) |
|                              |                              | 
|![foto3](https://github.com/nikitenkokatya/SendMessageViewBinding/assets/145988774/7659cbb3-9757-4608-bbdb-16ae6298108d)|![foto4](https://github.com/nikitenkokatya/SendMessageViewBinding/assets/145988774/85f1eb99-8bf3-4225-b1dc-14c14258afa2)|
