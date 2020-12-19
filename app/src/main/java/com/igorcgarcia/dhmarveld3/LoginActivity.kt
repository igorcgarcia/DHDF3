package com.igorcgarcia.dhmarveld3

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.igorcgarcia.dhmarveld3.databinding.ActivityLoginBinding


//ClienteId e ClientSecret -- Google
//ClienteId = 736134215380-p7j8dbo4d3ehf6agtlaut9gjf93rjpce.apps.googleusercontent.com
//ClientSecret = jx7vmyg_I6uliwftaXhmmzfB

class LoginActivity : AppCompatActivity() {

//
//    private val callbackManager by lazy {
//        CallbackManager.Factory.create();
//    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.btCreateAccount.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }


//        LoginManager.getInstance().registerCallback(callbackManager,
//                object : FacebookCallback<LoginResult?> {
//                    override fun onSuccess(loginResult: LoginResult?) {
//                        // App code
//                        Log.i("TESTE", "FB-onSuccess")
//                    }
//
//                    override fun onCancel() {
//                        // App code
//                        Log.i("TESTE", "FB-onCancel")
//                    }
//
//                    override fun onError(exception: FacebookException) {
//                        // App code
//                        Log.i("TESTE", "FB-onError")
//                    }
//                })

//        //Google
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build()
//
//        // Build a GoogleSignInClient with the options specified by gso.
//        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        val signInButton = binding.signInButton
//        signInButton.setSize(SignInButton.SIZE_STANDARD)
//
//        val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//
//        signInButton.setOnClickListener{
//            Log.i("TESTE", "teste")
//        }

    }

//    override fun onResume() {
//        super.onResume()
//        val account = GoogleSignIn.getLastSignedInAccount(this)
//
//        //Facebook
//        val accessToken = AccessToken.getCurrentAccessToken()
//        val isLoggedIn = accessToken != null && !accessToken.isExpired
//
////        if (isLoggedIn) {
////            binding.loginButton.isVisible = false
////        } else {
//            binding.loginButton.setPermissions("email")
////        }
//    }
//
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager.onActivityResult(requestCode, resultCode, data)
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode === RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(attr.data)
//            handleSignInResult(task)
//        }
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//
//            // Signed in successfully, show authenticated UI.
////            updateUI(account)
//        } catch (e: ApiException) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
////            updateUI(null)
//        }
//    }
//
//    val RC_SIGN_IN = 999
}