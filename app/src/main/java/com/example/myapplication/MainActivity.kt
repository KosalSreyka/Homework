package com.example.myapplication

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.homework.RegisterViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel= ViewModelProvider(this)[RegisterViewModel::class.java]
            Column(Modifier.fillMaxWidth()
                .padding(15.dp)) {
                Row{
                    Text(text = "Registration Form" , fontSize = 20.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.AccountCircle , contentDescription =null,Modifier.size(20.dp))
                }
                TextFieldComponent(viewModel,{viewModel.nameChange(it)},"name","Enter name","Full Name",Modifier.fillMaxWidth())
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    TextFieldComponent(viewModel,{viewModel.genderChange(it)},"gender", "Gender", "Gender", Modifier.weight(1f))
                    Spacer(modifier = Modifier.weight(0.1f))
                    TextFieldComponent(viewModel,{viewModel.phoneChange(it)},"phone", "Phone", "Phone", Modifier.weight(2f))
                }

                TextFieldComponent(viewModel,{viewModel.addressChange(it)},"address", "Address", "Address",Modifier.fillMaxWidth())
                if(viewModel.register.value.name!=""&&viewModel.register.value.address!=""&&viewModel.register.value.gender!=""&&viewModel.register.value.phone!="") ButtonComponent(true)
                else ButtonComponent(false)


            }

        }
    }
}

@Composable
fun TextFieldComponent(
    data: RegisterViewModel,
    TextChange:(String)->Unit,
    text:String, placeholder:String, label:String, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = if (text == "name") data.register.value.name else if (text == "address") data.register.value.address else if (text == "gender") data.register.value.gender else data.register.value.phone,
        onValueChange = {
            TextChange(it)
        },
        modifier=modifier,
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions( keyboardType = if(text=="phone") KeyboardType.Number else KeyboardType.Text   , imeAction= ImeAction.Done )
    )

}
@Composable
fun ButtonComponent(status:Boolean) {
     Button(onClick = {}, enabled = status , modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp)) {
        Text("Register")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}