---
header-includes:
 - \usepackage{fvextra}
 - \DefineVerbatimEnvironment{Highlighting}{Verbatim}{breaklines,commandchars=\\\{\}}
---

# Proyecto del tema 1 de PMDM hecho por Darío Romero Romera

## Archivo de manifiesto

Lo más a destacar es que tenemos dos activities en el XML de nuestro `AndroidManifest.xml` y que hemos añadido tres permisos:

 - Para telefonía
 - Para uso de Internet por parte del activity que abre la web
 - Para poner una alarma

Para el del teléfono hemos añadido también una etiqueta sobre la utilización de telefonía.
```XML
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">


    <uses-feature
        android:name="android.hardware.telephony"
        android:required="false" />
    <uses-permission android:name="android.permission.CALL_PHONE" />
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="com.android.alarm.permission.SET_ALARM"/>
```

Todos estos permisos deben colgar directamente de la etiqueta `<manifest></manifest>`{.XML}

\pagebreak

## Apariencia gráfica

### XML de la activity principal

Este es el código de la apariencia de la activity principal. Utilizo un `ConstraintLayout`. Tengo un `TextView` en el centro, y en base a su inicio y a su fin cuelgan de él dos botones con imagen. Debajo de los botones hay un `TextView` describiendo en una palabra la función del botón. Debajo de esos `TextView` hay otro `ImageButton` con texto igual que los de arriba. Todos los anchos y altos se envuelven al contenido. Todos los textos de la aplicación se han creado en el fichero strings.xml.

```XML
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:background="@color/grey">

    <TextView
        android:id="@+id/tv_mainText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/main_activity_text"
        android:textSize="40sp"
        android:textStyle="bold"
        android:textColor="@color/cyan"
        android:layout_margin="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    <ImageButton
        android:id="@+id/btn_goto_call"
        android:layout_margin="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="@id/tv_mainText"
        app:layout_constraintTop_toBottomOf="@id/tv_mainText"
        android:src="@drawable/baseline_phone_24"
        android:contentDescription="@string/phone_description"
        />
    <TextView
        android:id="@+id/tv_callText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/texto_llamar"
        app:layout_constraintTop_toBottomOf="@id/btn_goto_call"
        app:layout_constraintStart_toStartOf="@id/btn_goto_call"
        app:layout_constraintEnd_toEndOf="@id/btn_goto_call"
        android:textSize="15sp"
        />

    <ImageButton
        android:id="@+id/btn_alarm"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/baseline_alarm_24"
        app:layout_constraintEnd_toEndOf="@id/tv_mainText"
        app:layout_constraintTop_toBottomOf="@id/tv_mainText"
        android:layout_margin="20dp"
        android:contentDescription="@string/alarm_description"
        />

    <TextView
        android:id="@+id/tv_alarmText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/texto_alarma"
        app:layout_constraintTop_toBottomOf="@id/btn_alarm"
        app:layout_constraintStart_toStartOf="@id/btn_alarm"
        app:layout_constraintEnd_toEndOf="@id/btn_alarm"
        android:textSize="15sp"
        />

    <ImageButton
        android:id="@+id/btn_web"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/baseline_public_24"
        app:layout_constraintTop_toBottomOf="@id/tv_callText"
        app:layout_constraintStart_toStartOf="@id/btn_goto_call"
        android:layout_marginTop="20dp"
        android:contentDescription="@string/web_description"
        />

    <TextView
        android:id="@+id/tv_webText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/texto_web"
        app:layout_constraintTop_toBottomOf="@id/btn_web"
        app:layout_constraintStart_toStartOf="@id/btn_web"
        app:layout_constraintEnd_toEndOf="@id/btn_web"
        />

   <ImageButton
        android:id="@+id/btn_mail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/baseline_email_24"
        app:layout_constraintTop_toBottomOf="@id/tv_alarmText"
        app:layout_constraintStart_toStartOf="@id/btn_alarm"
        android:layout_marginTop="20dp"
       android:contentDescription="@string/calendar_description"
        />

    <TextView
        android:id="@+id/tv_mail_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/btn_mail"
        app:layout_constraintStart_toStartOf="@+id/btn_mail"
        app:layout_constraintEnd_toEndOf="@+id/btn_mail"
        android:text="@string/texto_correo"
        android:textSize="15sp"
        />

</androidx.constraintlayout.widget.ConstraintLayout>
```

\pagebreak

### XML de el segundo activity

Como utilizamos un intent explícito para abrir un segundo activity donde va a estar el intent que va a realizar la llamada por teléfono debemos también crear una apariencia para este activity.

Para este activity he usado un `LinearLayout`. Solo hay cuatro elementos. El primero es un `TextView` en la que indico que este activity es la sección donde se realiza la llamada. Luego tenemos un `ImageButton` que es el que va a ejecutar la funcionalidad de la llamada. Luego tenemos otro `TextView` que dice "Llamar a el número de Darío". Finalmente hay un `Button` con la palabra volver que nos devuelve al primer activity.

```XML
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Second"
    android:orientation="vertical">
    
    <TextView
        android:id="@+id/tv_sectionText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/section_text"
        android:textStyle="bold"
        android:textColor="@color/dark_yellow"
        android:textSize="40sp"
        />

    <ImageButton
        android:id="@+id/btn_call"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:contentDescription="@string/phone_description"
        android:src="@drawable/baseline_big_phone_24" />

    <TextView
        android:id="@+id/tv_callEmergenciesText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/texto_llamar_numero"
        android:textSize="20sp"
        />

    <Button
        android:id="@+id/btn_back"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/texto_volver"
        />

</androidx.appcompat.widget.LinearLayoutCompat>
```

\pagebreak

## Clases y su código

### MainActivity

```Kotlin
class MainActivity : AppCompatActivity() {
    private lateinit var btnGotoCall : ImageButton
    private lateinit var btnAlarm : ImageButton
    private lateinit var btnWeb : ImageButton
    private lateinit var btnMail : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEvent()
    }

    private fun initEvent() {
        btnGotoCall = findViewById(R.id.btn_goto_call)
        btnAlarm = findViewById(R.id.btn_alarm)
        btnWeb = findViewById(R.id.btn_web)
        btnMail = findViewById(R.id.btn_mail)

        btnGotoCall.setOnClickListener { view ->
            val intent = Intent(this, Second::class.java)

            startActivity(intent)
        }

        btnAlarm.setOnClickListener { view ->
            // NO PONER UN DELAY MAYOR A 60
            val DELAY = 2
            var hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            var minutos = Calendar.getInstance().get(Calendar.MINUTE) + DELAY

            if (minutos >= 60) {
                minutos -= 60
                if (hora != 23)
                    hora += 1
                else
                    hora = 0
            }

            var intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, hora)
                putExtra(AlarmClock.EXTRA_MINUTES, minutos)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma creada por AppBotones")
            }


            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }

        btnWeb.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.w3schools.com")
            }

            startActivity(intent)
        }



        btnMail.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_SEND).apply {
                type="*/*"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("dromrom0206@g.educaand.es"))
                putExtra(Intent.EXTRA_SUBJECT, "Correo desde AppBotones")
                putExtra(Intent.EXTRA_TEXT, "Este es el mensaje del correo")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}
```

Al principio de la clase **declaramos** los cuatro `ImageButton` que vamos a necesitar, aunque con la palabra reservada `lateinit` indicamos que las variables no van a ser inicializadas todavía.

En el método inicial `onCreate()` ejecutamos el método `initEvent()`. Este método carga las referencias de los botones en las variables declaradas al principio y luego con las expresiones lambda se agrega la funcionalidad personalizada a cada botón.

El botón `btnGotoCall` crea un intent de tipo **explícito** que nos redirige a el segundo activity.

El botón `btnAlarm` crea una alarma a través de un intent **implícito** llamado `AlarmClock.SET_ALARM`. Para hacer que la alarma suene dentro de 2 minutos tengo que saber qué hora es. Me creo variables hora y minutos y los relleno con los valores que me dan `Calendar.getInstance().get(HOUR_OF_DAY)` y `Calendar.getInstance().get(MINUTE)`. También tengo una variable `DELAY`, que indica dentro de cuánto se va a iniciar la alarma, en este caso 2 minutos. Al inicializar los minutos le añado el delay. Como estoy trabajando con números convencionales, si por casualidad fuesen las y 59 y a los minutos le sumo 2 minutos más la alarma intentaría sonar a las y 61 lo cual es **imposible** y al intentarlo se nos abre la alarma pero tenemos que indicar ahora nosotros la hora. En estos casos lo que hago es restar 60 minutos y avanzar una hora, y cuando ya son las 23, como no pueden ser las 24 se resetea a las 00.

Una vez hemos controlado la hora ya dentro del intent indicamos la información con los `putExtra()`. Yo indico la hora, minutos y un mensaje indicando que la alarma ha sido creada a través de la aplicación.

El botón `btnWeb` abre un intent **implícito** de tipo `ACTION_VIEW`. Hago un apply y seteo data a un `Uri.parse()`. El formato de URL es http: o https: seguido de la URL a donde queremos ir, en mi caso he puesto **www.w3schools.com**.

El botón `btnMail` abre un intent **implícito** de tipo `ACTION_SEND`. La información de los `putExtra()` que hemos utilizado es el destinatario, el asunto y el texto del correo. El destinatario, aunque sea uno como en este caso debe ser pasado como **array**, si no no funciona.

\pagebreak

### Second

Second es el segundo activity, que contiene la funcionalidad de llamar por teléfono. Este es su código:

```Kotlin
class Second : AppCompatActivity() {
    private lateinit var btnCall : ImageButton
    private lateinit var btnBack : Button
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted)
            call()
        else
            Toast.makeText(this, "Error: permisos denegados", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initEvent()
    }

    private fun initEvent() {
        btnCall = findViewById(R.id.btn_call)
        btnBack = findViewById(R.id.btn_back)

        btnCall.setOnClickListener { view ->
            requestPermission()
        }

        btnBack.setOnClickListener { view ->
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (hasPermission())
                call()
            else
                requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        } else
            call()
    }

    private fun call() {
        var intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:603779410")
        }
        startActivity(intent)
    }

    private fun hasPermission() : Boolean = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
}
```

Nos creamos tres variables, una de tipo `ImageButton`, otra de tipo `Button` y otra va a ser una variable que guarde en sí una función.

Esa función lo que hace es mandarnos el pop-up que nos pide permisos. Hacemos una expresión lambda del código a ejecutar e it, que ahora llamamos isGranted guarda un valor **booleana**. Esta variable nos indica si el usuario ha aceptado los permisos o no. Si ha aceptado los permisos ejecuta el método `call()` (creado por nosotros) y si no nos manda un `Toast` con un mensaje de error.

Tenemos un `initEvent()` que inicializa los botones al igual que en el otro activity. El botón de volver `btnBack` es un intent explícito que nos lleva a MainActivity.

El botón `btnCall` llama a el método `requestPermission()`, que lo que hace es comparar nuestra versión de API con la API *M*, que es la equivalente a la 23. Si nuestra API es mayor o igual a la 23 comprueba con un if si tenemos permiso. Esto lo hace con el método `hasPermission()`, que mira si tenemos el permiso CALL_PHONE concedido. Si tenemos permiso realiza la llamada, si no, pide permiso con el método launch de la variable que nos creamos al principio de la clase que tenía una expresión lambda. Si es menor a la 23 simplemente realiza la llamada con el método `call()`.

El método call lo que hace es crear un intent `ACTION_CALL`. Se le pone el apply y se le setea data a Uri.parse() con el número de teléfono. El formato del número debe ser tel:xxxx... Siendo las x los números que componen el teléfono.