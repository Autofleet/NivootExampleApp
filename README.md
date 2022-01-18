# nivoot example app
example app using autofleet navigation android sdk


## HOW TO USE NIVOOT?
STEPS:
1.app/build.gradle (app level) - add nivoot dependency

    dependencies {
        ....
        implementation 'com.github.Autofleet:nivoot:0.0.9'
        ....
    }
    
    
    
2.build.gradle (project level) - add jitpack maven repo at the bottom

    allprojects {
      repositories {
          ....
          maven {
              url "https://jitpack.io"
          }
      }
    }
3.prerequirement:

    BASE_URL - url to autofleet environement
    TOKEN - token that will be fetched from autofleet api through server to server authentication and then will be sent to the driver-app by your server.
    
4.implementation example:


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

        // when clicking back button
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
