package com.ass.bulletin.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ass.bulletin.ui.util.setAvalancheDangerColor
import com.ass.bulletin.ui.util.setTheAvalancheDangerLevelDescription
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.components.fab.FabButtonItem
import com.ass.core.designsystem.theme.*
import com.ass.core.designsystem.R
import com.ass.core.foundation.navigation.AssNavDestinations
import com.ass.nav_bar.AssNavigationBar
import com.ass.top_bar.AssTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun BulletinRoute(
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,
    modifier: Modifier = Modifier,
    viewModel: BulletinViewModel = koinViewModel(),
) {
    BulletinScreen(
        upperTriangleDangerLevel = "3/4",
        mediumTriangleDangerLevel = "2/4",
        bottomTriangleDangerLevel = "1/4",
        fetchData = viewModel::fetchData,
        navigateByNavBar = navigateByNavBar,
        navigateByFab = navigateByFab,
        selectedItem = selectedItem,
        modifier = modifier
    )
}

@Composable
fun BulletinScreen(
    upperTriangleDangerLevel: String,
    mediumTriangleDangerLevel: String,
    bottomTriangleDangerLevel: String,
    fetchData: () -> Unit,
    modifier: Modifier = Modifier,
    navigateByNavBar: (AssNavDestinations) -> Unit,
    navigateByFab: (FabButtonItem) -> Unit,
    selectedItem: MutableIntState,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = { AssTopBar(onBack = {}) },
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
            BulletinCommonDanger(
                setTheAvalancheDangerLevelDescription = { setTheAvalancheDangerLevelDescription(it) },
                setAvalancheDangerColor = { setAvalancheDangerColor(it) },
                modifier = modifier
            )
            Spacer(modifier = modifier.size(AssPaddings.padding32dp))
            BulletinTriangleOfElevation(
                upperTriangleDangerLevel,
                mediumTriangleDangerLevel,
                bottomTriangleDangerLevel,
                modifier
            )
            Spacer(modifier = modifier.size(AssPaddings.padding16dp))
            AvalancheProblems(modifier)
            Spacer(modifier = modifier.size(AssPaddings.padding16dp))
            BulletinMetaInfo(modifier)
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
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            imageVector = AssIcons.AvalancheProblemNewSnow,
            contentDescription = stringResource(R.string.avalanche_problem),
            alpha = AssAlpha.alpha05,
            modifier = Modifier
                .border(
                    BorderStroke(AssPaddings.padding1dp, AssTheme.colorScheme.primary),
                    shape = RoundedCornerShape(AssCornerRadius.cornerRadius16dp)
                )
                .size(AssSize.size80dp)
                .clip(RoundedCornerShape(AssPaddings.padding10dp))
        )
        Spacer(modifier = modifier.padding(AssPaddings.padding2dp))
        Text(
            text = avalancheProblemType,
            style = AssTheme.typography.labelLarge.copy(color = AssTheme.colorScheme.primary),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BulletinPreview() {
    BulletinScreen(
        upperTriangleDangerLevel = "3/4",
        mediumTriangleDangerLevel = "2/4",
        bottomTriangleDangerLevel = "1/4",
        fetchData = {},
        navigateByNavBar = {},
        navigateByFab = {},
        selectedItem = remember { mutableIntStateOf(1) }
    )
}