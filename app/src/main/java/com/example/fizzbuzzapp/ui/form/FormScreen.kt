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
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Helps to move to the next input and clear focus
        val focusManager = LocalFocusManager.current

        // A little introduction message to welcome the user
        IntroductionText(stringResource(R.string.app_intro_message))

        // Creating the inputs and binding their value to the ViewModel
        AppTextField(
            text = viewModel.firstNumberInput,
            label = stringResource(R.string.first_number_input_label),
            placeholder = stringResource(R.string.first_number_input_placeholder),
            onChange = {
                viewModel.firstNumberInput = it.filter { input -> input.isDigit() }
                viewModel.firstNumberInputError = viewModel.isNumberInputInError(viewModel.firstNumberInput)
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            showError = viewModel.firstNumberInputError,
            errorMessage = stringResource(R.string.number_input_error_message)
        )

        AppTextField(
            text = viewModel.secondNumberInput,
            label = stringResource(R.string.second_number_input_label),
            placeholder = stringResource(R.string.second_number_input_placeholder),
            onChange = {
                viewModel.secondNumberInput = it.filter { input -> input.isDigit() }
                viewModel.secondNumberInputError = viewModel.isNumberInputInError(viewModel.secondNumberInput)
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            showError = viewModel.secondNumberInputError,
            errorMessage = stringResource(R.string.number_input_error_message)
        )

        AppTextField(
            text = viewModel.firstTextInput,
            label = stringResource(R.string.first_text_input_label),
            placeholder = stringResource(R.string.first_text_input_placeholder),
            onChange = {
                viewModel.firstTextInput = it
                viewModel.firstTextInputError = viewModel.isTextInputInError(viewModel.firstTextInput)
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            showError = viewModel.firstTextInputError,
            errorMessage = stringResource(R.string.text_input_error_message)
        )

        AppTextField(
            text = viewModel.secondTextInput,
            label = stringResource(R.string.second_text_input_label),
            placeholder = stringResource(R.string.second_text_input_placeholder),
            onChange = {
                viewModel.secondTextInput = it
                viewModel.secondTextInputError = viewModel.isTextInputInError(viewModel.secondTextInput)
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onDone = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            showError = viewModel.secondTextInputError,
            errorMessage = stringResource(R.string.text_input_error_message)
        )

        AppTextField(
            text = viewModel.limitInput,
            label = stringResource(R.string.limit_input_label),
            placeholder = stringResource(R.string.limit_input_placeholder),
            onChange = {
                viewModel.limitInput = it.filter { input -> input.isDigit() }
                viewModel.limitInputError = viewModel.isNumberInputInError(viewModel.limitInput)
            },
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number,
            keyBoardActions = KeyboardActions(
                onDone = {
                    // User is done with his inputs, remove the keyboard and clear focus
                    focusManager.clearFocus()
                }
            ),
            showError = viewModel.limitInputError,
            errorMessage = stringResource(R.string.number_input_error_message)
        )

        GradientButton(
            text = stringResource(R.string.validate_form_button_text),
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.default_padding))
                .fillMaxWidth(),
            onClick = {
                viewModel.areInputsValid()
                //if (viewModel.areInputsValid())
                    //Navigate to next screen
            }
        )
    }
}

