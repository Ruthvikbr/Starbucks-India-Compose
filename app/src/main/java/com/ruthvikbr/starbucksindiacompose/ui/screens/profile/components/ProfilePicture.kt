
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.screens.profile.components.ProfileEditButton
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreenSecondary
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite

@Composable
fun ProfilePicture() {
    ConstraintLayout {
        val (box, icon) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(box) {
                    top.linkTo(parent.top)
                }
                .size(200.dp)
                .clip(CircleShape)
                .background(PrimaryWhite)
                .clickable { },
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .size(190.dp)
                    .clip(CircleShape)
                    .background(PrimaryWhite)
                    .border(width = 6.dp, color = HouseGreenSecondary, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Fit,
                )
            }
        }
        ProfileEditButton(
            modifier = Modifier
                .constrainAs(icon) {
                    top.linkTo(box.bottom, margin = (-24).dp)
                    centerHorizontallyTo(parent)
                }
                .size(24.dp)
                .clip(CircleShape)
                .background(AccentGreen)
                .clickable { },
        )
    }
}
