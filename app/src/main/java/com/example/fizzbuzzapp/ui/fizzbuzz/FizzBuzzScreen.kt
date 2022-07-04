package com.example.fizzbuzzapp.ui.fizzbuzz

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import com.example.fizzbuzzapp.ui.fizzbuzz.components.AppCard
import com.example.fizzbuzzapp.ui.form.FormViewModel

@Composable
fun FizzBuzzScreen(
    fizzBuzzViewModel: FizzBuzzViewModel,
    formViewModel: FormViewModel,
) {
    // Init the FizzBuzzRepository limit and fetch some items
    fizzBuzzViewModel.fetchMoreItems(formViewModel.limitInput.toInt())

    val listState = rememberLazyListState()
    LazyColumn(state = listState){
        items(fizzBuzzViewModel.itemsList){ item ->
            AppCard(text = fizzBuzzViewModel.getFizzBuzzValue(
                value = item,
                firstNumberInput = formViewModel.firstNumberInput,
                secondNumberInput = formViewModel.secondNumberInput,
                firstTextInput = formViewModel.firstTextInput,
                secondTextInput = formViewModel.secondTextInput,
            ))
        }
    }

    // call the extension function, buffer makes the call before
    // we reach the last item so we can scroll smoothly
    listState.OnBottomReached(buffer = 3) {
        // do on load more
        fizzBuzzViewModel.fetchMoreItems(formViewModel.limitInput.toInt())
    }
}

@Composable
fun LazyListState.OnBottomReached(
    buffer : Int = 0,
    loadMore : () -> Unit
){
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1 - buffer
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore){
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
            }
    }
}