# nivoot example app
This is an example app using the Autofleet navigation android SDK


## HOW TO USE NIVOOT
### Step 1: app/build.gradle (app level) - add nivoot dependency

    dependencies {
        ....
        implementation 'com.github.Autofleet:nivoot:1.0.3'
        ....
    }
    
    
### Step 2: build.gradle (project level) - add jitpack maven repo at the bottom

    allprojects {
      repositories {
          ....
          maven {
              url "https://jitpack.io"
          }
      }
    }
    
### Step 3: Pre-requirement:

    BASE_URL - URL to an Autofleet environement
    TOKEN - the token that will be fetched from the Autofleet API through server to server authentication and then will be sent to the driver-app by your server
    
### Step 4: Implementation example:


    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        // TODO: get token from network call, shared pref, local storage...
        fun getToken(): String {
            return "YOUR_TOKEN_HERE"
        }

        private val BASE_PATH = "BASE_PATH_HERE"

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            setLisetners()
        }

        // when clicking the back button
        fun onCloseHandler() {
            Log.d("MainActivity", "nivoot has been closed")
        }

        fun setLisetners() {
            binding.buttonStartSdkNavigation.setOnClickListener {
                NivootLauncher.startActivity(
                    this,
                    onClose=::onCloseHandler,
                    token=this.getToken(),
                    wsUrl=BASE_PATH)
            }
        }
    }
