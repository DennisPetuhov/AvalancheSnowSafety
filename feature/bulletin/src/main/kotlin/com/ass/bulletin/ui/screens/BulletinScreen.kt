package com.ass.bulletin.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ass.bulletin.ui.AvalancheProblems
import com.ass.bulletin.ui.BulletinCommonDanger
import com.ass.bulletin.ui.BulletinMetaInfo
import com.ass.bulletin.ui.BulletinUiState
import com.ass.bulletin.ui.util.BulletinTriangleOfElevation
import com.ass.bulletin.ui.util.setAvalancheDangerColor
import com.ass.bulletin.ui.util.setTheAvalancheDangerLevelDescription
import com.ass.core.designsystem.R
import com.ass.core.designsystem.components.navbar.AssTopBar
import com.ass.core.designsystem.theme.*
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.nav_bar.AssNavigationBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun BulletinRoute(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    selectedItem: MutableIntState,
    modifier: Modifier = Modifier,
    viewModel: BulletinViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    BulletinScreen(
        uiState = uiState,
        fetchDataApi = viewModel::fetchDataApi,
        navigateByNavBar = navigateByNavBar,
        selectedItem = selectedItem,
        modifier = modifier
    )
}

@Composable
fun BulletinScreen(
    uiState: BulletinUiState,
    fetchDataApi: () -> Unit,
    modifier: Modifier = Modifier,
    navigateByNavBar: (AssNavDestinations) -> Unit,
    selectedItem: MutableIntState,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = { AssTopBar(titleText = R.string.bulletin, onNavClick = {}) },
        bottomBar = { AssNavigationBar(navigateByNavBar, selectedItem) },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues)
                .padding(horizontal = AssPaddings.padding16dp)
                .padding(top = AssPaddings.padding8dp)
        ) {
            Button(onClick = { fetchDataApi() }, modifier = modifier.fillMaxWidth()) { Text("API") }
            BulletinCommonDanger(
                setTheAvalancheDangerLevelDescription = { setTheAvalancheDangerLevelDescription(it) },
                setAvalancheDangerColor = { setAvalancheDangerColor(it) },
                modifier = modifier
            )
            Spacer(modifier = modifier.size(AssPaddings.padding32dp))
            BulletinTriangleOfElevation(
                hazardRatings = uiState.hazardRatings,
                modifier
            )
            Spacer(modifier = modifier.size(AssPaddings.padding16dp))
            AvalancheProblems(uiState, modifier)
            Spacer(modifier = modifier.size(AssPaddings.padding16dp))
            BulletinMetaInfo(uiState.bulletinMetadata, modifier)
            Spacer(modifier = modifier.size(AssPaddings.padding16dp))
        }
    }
}

@Composable
fun AvalancheProblemIconAndType(
    avalancheProblemImage: ImageVector,
    avalancheProblemType: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.wrapContentSize()

    ) {
        Image(
            imageVector = avalancheProblemImage,
            contentDescription = stringResource(R.string.avalanche_problem),
            alpha = AssAlpha.alpha05,
            modifier = Modifier
                .size(AssSize.size80dp)
                .clip(RoundedCornerShape(AssCornerRadius.cornerRadius16dp))
                .border(
                    border = BorderStroke(AssBorder.width1dp, AssTheme.colorScheme.primary),
                    shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp)
                )
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding4dp))
        Text(
            text = avalancheProblemType,
            style = AssTheme.typography.labelLarge.copy(color = AssTheme.colorScheme.primary),
        )
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun BulletinPreview() {
//    BulletinScreen(
//        hazardRatings = HazardRatings(),
//        fetchDataApi = {},
//        fetchDataDb = {},
//        navigateByNavBar = {},
//        selectedItem = remember { mutableIntStateOf(1) }
//    )
//}