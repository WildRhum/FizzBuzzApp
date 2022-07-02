package com.example.fizzbuzzapp.ui.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fizzbuzzapp.R
import com.example.fizzbuzzapp.ui.form.components.AppTextField
import com.example.fizzbuzzapp.ui.form.components.GradientButton
import com.example.fizzbuzzapp.ui.form.components.IntroductionText

@Composable
fun FormScreen(
    navController: NavController,
    viewModel: FormViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(R.dimen.default_padding)),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Helps to move to the next input
        val focusManager = LocalFocusManager.current

        // A little introduction message to welcome the user
        IntroductionText(stringResource(R.string.app_intro_message))

        // Creating the inputs and binding their value to the ViewModel
        AppTextField(
            text = viewModel.firstInputNumber,
            label = stringResource(R.string.first_number_input_label),
            placeholder = stringResource(R.string.first_number_input_placeholder),
            onChange = {
                viewModel.firstInputNumber = it
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        AppTextField(
            text = viewModel.secondInputNumber,
            label = stringResource(R.string.second_number_input_label),
            placeholder = stringResource(R.string.second_number_input_placeholder),
            onChange = {
                viewModel.secondInputNumber = it
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        AppTextField(
            text = viewModel.firstInputText,
            label = stringResource(R.string.first_word_input_label),
            placeholder = stringResource(R.string.first_word_input_placeholder),
            onChange = {
                viewModel.firstInputText = it
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        AppTextField(
            text = viewModel.secondInputText,
            label = stringResource(R.string.second_word_input_label),
            placeholder = stringResource(R.string.second_word_input_placeholder),
            onChange = {
                viewModel.secondInputText = it
            },
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onDone = {
                    // User is done with his inputs, remove the keyboard and clear focus
                    focusManager.clearFocus()
                }
            )
        )

        GradientButton(
            text = stringResource(R.string.validate_form_button_text),
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.default_padding))
                .fillMaxWidth()
        )
    }
}

