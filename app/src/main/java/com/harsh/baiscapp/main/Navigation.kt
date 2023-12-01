package com.harsh.baiscapp.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Routes {
   const val SIGNUP = "signup"
   const val DASHBOARD = "Dashboard"
   const val OTP = "Otp"

}



@Composable fun MainNavigation(){
   val navController = rememberNavController()
   NavHost(navController = navController, startDestination = Routes.SIGNUP) {

//        for login page
      composable(Routes.SIGNUP) {
         SignupPage(navController = navController)
      }

//        for otp page
      composable(
         route = "$Routes.OTP?name={name}&phoneNumber={phoneNumber}&password={password}",
         arguments = listOf(
             navArgument("name") { type = NavType.StringType },
            navArgument("phoneNumber") { type = NavType.StringType },
            navArgument("password") { type = NavType.StringType }
         )
      ) { backStackEntry ->
          val name= backStackEntry.arguments?.getString("name") ?: ""
         val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
         val password = backStackEntry.arguments?.getString("password") ?: ""
         OtpPage(navController = navController, name = name ,phoneNumber = phoneNumber, password = password)
      }


//        for dashboard page
      composable(
         route = "$Routes.DASHBOARD?name={name}&phoneNumber={phoneNumber}&password={password}",
         arguments = listOf(
             navArgument("name") { type = NavType.StringType },
            navArgument("phoneNumber") { type = NavType.StringType },
            navArgument("password") { type = NavType.StringType }
         )
      ) { backStackEntry ->
          val name= backStackEntry.arguments?.getString("name") ?: ""
         val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
         val password = backStackEntry.arguments?.getString("password") ?: ""
         DashBoard(navController = navController,name = name, phoneNumber = phoneNumber, password = password)
      }
   }
}
