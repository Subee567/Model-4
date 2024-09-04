package drawable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.model4.R

@Composable
fun ChoicePF(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).background(color = Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Choose your role", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("mentor_home")
                }
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable._920x1080),
                    contentDescription = "Mentor Icon",
                    modifier = Modifier.fillMaxWidth().height(140.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mentor",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Help others by sharing your knowledge and experience.",
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("mentee_home")
                }
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.__bit_city_1920x1080),
                    contentDescription = "Mentor Icon",
                    modifier = Modifier.height(140.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Mentee",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Learn and grow with guidance from experienced mentors.",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun RoleCard(
    title: String,
    description: String,
    imageRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(80.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp)
            .then(
                if (isSelected) Modifier.background(Color.LightGray) else Modifier
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Preview
@Composable
fun ChoicePFPreview() {
    val navController = rememberNavController()
    ChoicePF(navController = navController)
}