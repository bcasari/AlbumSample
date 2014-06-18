Quick explanation to what was updated to Album Sample

1. As you can see we created 1000 dummy entries in our list fragment. For the sake of simplicity let’s keep this dummy data generation, but let’s assume we have a lot more entries in our list. If there’s a way we could optimize our adapter, how would we do it? Please refactor the code as you see fit.

I used the View Holder pattern on the ListAdapter so that we do not need to keep finding View By Ids within the adapter as this is an expensive operation.


2. When we open the drawer we can select different sections. You will see “Albums”, “Songs” and “Artists”. However, there’s no contextual information for the user. It doesn’t matter if the drawer is opened or closed, or if a drawer item is clicked, the action bar title is always the same. Let’s change this such that when the drawer is opened we display the name of our app and upon an item selection we display the item’s name.

This is self-explanatory in code.

3. Now our application provides more information to the user, but the list always displays the same items. Let’s change our list whenever the user selects another item from the drawer. For the sake of simplicity you can simply create dummy items and change the main header.

This is self-explanatory in code.

4. Now that we have different lists we can focus on the list items. The picture on said items is always the same. Imagine we have a server hosting our pictures. How could we change our current code to support loading these pictures. You don’t need to code the part that interacts with the network, just leave it with stub methods. Please describe your choices in a “readme” file. Please take into consideration performance and usability. We don’t want the user to feel like his/her device is not performing well and we still want to give the user the opportunity to interact with the app.

I decided to use the library LazyList (https://github.com/thest1/LazyList) as it downloads the images in a separate thread from the UI and it also caches the already downloaded images so it saves resources for future requests.

5. (BONUS) Adapt the app such that when using a tablet, instead of displaying a list of elements we display a grid with 2 columns.

Done. I created the ItemsGridView fragment that also uses the ItemsAdapter to render items.