# Chips Input Layout
A highly customizable Android ViewGroup for displaying Chips (specified in the Material Design Guide)!

<img src="https://github.com/tylersuehr7/chips-input-layout/blob/master/docs/screen_filterable_list.png" width="200"> <img src="https://github.com/tylersuehr7/chips-input-layout/blob/master/docs/screen_contact_chip_multiple.png" width="200"> <img src="https://github.com/tylersuehr7/chips-input-layout/blob/master/docs/screen_chips_multiple.png" width="200"> <img src="https://github.com/tylersuehr7/chips-input-layout/blob/master/docs/screen_contact_chip_details.png" width="200">

How to use it...

In your project level build.gradle :
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
} 
```

In your app level build.gradle:
```java
dependencies {
    compile 'com.github.julycarol:chips-input-layout:2.4'
}  
```

Core features of this library:
* Use libraries (Glide, Picasso,...) to load chip avatars
* Filter chips as user inputs text
* Allow user to create custom chips
* Specify if chips show details, are deletable, or have an avatar
* Specify how chips are managed/stored in-memory
* Validate any chips
* Highly customizable chips
* Strictly sticks to the Google Material Design Guide

*Honorable Mentions:*
* This uses a RecyclerView layout manager: https://github.com/BelooS/ChipsLayoutManager

## Using the `ChipsInputLayout`
The purpose of this library is to allow users to interact with chips, specified in the Google Material Design Guide. To achieve this functionality, you'll need to use the `ChipsInputLayout` view.

### Using in an XML layout
`ChipsInputLayout` can be used in any ViewGroup and supports all width and height attributes. Simple usage is shown here:
```xml
<com.tylersuehr.chips.ChipsInputLayout
        android:id="@+id/chips_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Start typing for chips... "
        android:textColorHint="#757575"
        android:textColor="#212121"
        app:chip_showDetails="true"/>
```

Here is a table of all the XML attributes available for this view:

Attribute | Type | Summary
--- | :---: | ---
`android:hint` | `string` | Hint shown in the chips input.
`android:textColorHint` | `color` | Text color of the hint shown in the chips input. 
`android:textColor` | `color` | Text color of chips input.
`app:allowCustomChips` | `boolean` | True if user is allowed to enter custom chips.
`app:hideKeyboardOnChipClick` | `boolean` | True if the keyboard should hide when a filterable chip is clicked.
`app:maxRows` | `int` | Maximum number of rows used to display chips.
`app:delimiter` | `string` | A custom delimiter used to submit new chips.
`app:delimiterRegex` | `boolean` | True if `app:delimiter` is a regular expression.
`app:chip_showDetails` | `boolean` | True if clicking a chip should show its details.
`app:chip_showAvatar` | `boolean` | True if each chip should show an avatar icon.
`app:chip_showDelete` | `boolean` | True if each chip should be deletable by the user.
`app:chip_deleteIcon` | `reference` | Changes the chips' delete icons.
`app:chip_deleteIconColor` | `color` | Color of each chips' delete icon.
`app:chip_backgroundColor` | `color` | Color of each chips' background.
`app:chip_backgroundDrawable` | `drawable` | Drawable of each chips' background.
`app:chip_errorBackgroundDrawable` | `drawable` | Drawable of each chips' error background.
`app:chip_textColor` | `color` | Text color of each chips' title and subtitle.
`app:chip_errorTextColor` | `color` | Text color of each chips' title and subtitle.
`app:details_deleteIconColor` | `color` | Color of each detailed chips' delete icon.
`app:details_backgroundColor` | `color` | Color of each detailed chips' background.
`app:details_textColor` | `color` | Text color of each detailed chips' title and subtitle.
`app:filter_elevation` | `dimension` | Elevation of the filterable list.
`app:filter_backgroundColor` | `color` | Color of the filterable list's background.
`app:filter_textColor` | `color` | Text color of the filterable list's items.

### Using in Java code
`ChipsInputLayout` can be programmatically added into any ViewGroup. Simple usage in an Activity is shown here:
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    ChipsInputLayout chipsInputLayout = new ChipsInputLayout(this);
    // Set any properties for chips input layout
    
    setContentView(chipsInputLayout);
}
```

Here is a table of all the accessible attributes available for this view:

Method | Summary
--- | ---
`setInputHint(CharSequence)` | Changes hint shown in the chips input.
`setInputHintTextColor(ColorStateList)` | Changes text color of the hint shown in the chips input. 
`setInputTextColor(ColorStateList)` | Changes text color of chips input.
`setShowDetailedChipsEnabled(boolean)` |  True if clicking a chip should show its details.
`setCustomChipsEnabled(boolean)` | True if user is allowed to enter custom chips.
`setHideKeyboardOnChipClick(boolean)` | True if the keyboard should hide when filterable chip is clicked.
`setMaxRows(int)` | Changes maximum number of rows used to display chips.
`setTypeface(Typeface)` | Changes the typeface of the ChipsInputLayout and all associated textual-based components.
`setDelimiter(String)` | Sets the customer delimiter to be used to separate new chips.
`setDelimiter(String, boolean)` | Sets the customer delimiter to be used to separate new chips. Boolean is whether string is a regular expression or not.
`setChipTitleTextColor(ColorStateList)` | Changes text color of each chips' title and subtitle.
`setShowChipAvatarEnabled(boolean)` | True if each chip should show an avatar icon.
`setChipsDeletable(boolean)` | True if each chip should be deletable by the user.
`setChipDeleteIconColor(ColorStateList)` | Changes color of each chips' delete icon.
`setChipBackgroundColor(ColorStateList)` | Changes color of each chips' background.
`setChipDeleteIcon(Drawable)` | Changes the each chips' delete icon.
`setChipDeleteIcon(int)` | Overload of setChipDeleteIcon(Drawable).
`setChipDetailsTextColor(ColorStateList)` | Changes text color of each detailed chips' title and subtitle.
`setChipDetailsBackgroundColor(ColorStateList)` | Changes color of each detailed chips' background.
`setChipDetailsDeleteIconColor(ColorStateList)` | Changes color of each detailed chips' delete icon.
`setFilterListBackgroundColor(ColorStateList)` | Changes color of the filterable list's background.
`setFilterListTextColor(ColorStateList)` | Changes text color of the filterable list's items.
`setFilterListElevation(float)` | Changes elevation of the filterable list.
`setInputType(int)` | Sets the text input type on the ChipsEditText.
`setOnChipsInputTextChangedListener(OnChipsInputTextChangedListener)` | Sets a text changed listener that gets invoked when text it changed on the ChipsEditText.

## Using the Chips
There are a plethora of ways you can manipulate chips in `ChipsInputLayout`. However, the main abilities afforded by `ChipsInputLayout` are that you can set a list of chips that can be filtered by user input and set a list of chips that are pre-selected. Other features are listed in the table below.

### Creating a chip
`Chip` is the base object needed for `ChipsInputLayout`, and associated components in the library, to work properly. `ChipsInputLayout` can work with anything that is a `Chip`. So, that means that you can create any type of 'chip' data you want... simply inherit the `Chip` class and you're good to go! 

Here's a small example:
```java
public class CoolChip extends Chip {
    private final String coolName;
    private final Uri coolPic;
    
    public CoolChip(String coolName, Uri coolPic) {
        this.coolName = coolName;
        this.coolPic = coolPic;
    }
    
    Override
    public String getTitle() {
        return coolName;
    }
    
    @Override
    public Uri getAvatarUri() {
        return coolPic;
    }
    
    // ...other chip methods that are required to implement
}
```

### Setting a filterable list of chips in `ChipsInputLayout`
`ChipsInputLayout` supports the ability to show/hide a list of chips that are filterable as the user inputs text into it. To use this feature, simply call `setFilterableChipList(List)` in `ChipsInputLayout`.

Not calling `setFilterableChipList(List)` will imply you don't wish to use that feature, therefore, `ChipsInputLayout`, will not show/hide the filterable list as the user inputs text.

Here is a simple example:
``` java
@Override
protected void onCreate(List<ContactChip> chips) {
    // ...Cool onCreate stuff in activity
    
    ChipsInputLayout chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
    
    // ...Cool logic to acquire chips
    List<AwesomeChip> chips = getReallyCoolChips();
        
    this.chipsInput.setFilterableChipList(chips);
}
```

### Setting a pre-selected list of chips in `ChipsInputLayout`
`ChipsInputLayout` supports the ability to set an already-selected list of chips. To use this feature, simply call `setSelectedChipList(List)` in `ChipsInputLayout`.

Here is a simple example:
```java
@Override
protected void onCreate(List<ContactChip> chips) {
    // ...Cool onCreate stuff in activity
    
    ChipsInputLayout chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
    
    // ...Cool logic to acquire chips
    List<TagChip> defaultChips = getDefaultTagChips();
        
    this.chipsInput.setSelectedChipList(chips);
}
```

### Other chip manipulation methods in `ChipsInputLayout`

Method | Summary
--- | ---
`addFilteredChip(Chip)` | Adds a new chip to the filterable chips, which will update the UI accordingly because of the change observers.
`addSelectedChip(Chip)` | Adds a new chip to the selected chips, which will update the UI accordingly because of the change observers.
`clearFilteredChips()` | Clears all the filterable chips, which will update the UI accordingly because of the change observers.
`clearSelectedChips()` | Clears all the selected chips, which will update the UI accordingly because of the change observers.
`getSelectedChips()` | Gets all the currently selected chips.
`getFilteredChips()` | Gets all the currently filtered chips.
`getOriginalFilterableChips()` | Gets all the originally set filterable chips.
`getSelectedChipByPosition(int)` | Gets a selected chip using the given index.
`getSelectedChipById(Object id)` | Gets a selected chip using the given ID, if possible.
`getSelectedChipByTitle(String, boolean)` | Gets a selected chip with exactly the given title or like the given title.
`getSelectedChipBySubtitle(String, boolean)` | Gets a selected chip with exactly the given subtitle or like the given subtitle.
`getFilteredChipPosition(int)` | Gets a filtered chip using the given index.
`getFilteredChipById(Object)` | Gets a filtered chip using the given ID, if possible.
`getFilteredChipByTitle(String, boolean)` | Gets a filtered chip with exactly the given title or like the given title.
`getFilteredChipBySubtitle(String, boolean)` | Gets a filtered chip with exactly the given subtitle or like the given subtitle.
`doesChipExist(Chip)` | Checks if the given chip exists in either the filterable or selected chips.
`isChipFiltered(Chip)` | Checks if the given chip exists in the filtered chips.
`isChipSelected(Chip)` | Checks if the given chip exists in the selected chips.
`getChipDataSource()` | Gets the currently used chip data source.
`changeChipDataSource(ChipDataSource)` | Changes the chip data source being used to manage chips, cloning existing observers.

## Managing the Chips
Where this library capitalizes, is how it decentralizes where and how the selected and filterable chips are stored. This makes accessing and receiving updates to data source changes from various Android components really simple. 

All chips are managed by, `ChipDataSource`, which is an abstraction to decouple the concrete implementation of how the abstract methods manage the chips. This means that other implementations of `ChipDataSource` can be made at your own leisure. Simply call `changeChipDataSource(ChipDataSource)` in `ChipsInputLayout` to use your implementation of `ChipDataSource`.

Although not required, but definitely recommeneded, you can inherit the semi-concrete, `ObservableChipDataSource`, which is an implementation of `ChipDataSource` that handles the observer functionality for you properly so that it simplifies writing other `ChipDataSource` implementations.

By default, `ChipsInputLayout` will automatically use `ListChipDataSource`; which is out-of-the-box really good at being processing and memory efficient, and it relies on the `ArrayList` to manage chips.

### Observing chip selection changes
`ChipDataSource` has the ability to notify observers that want to observe specific chip selection events in `ChipDataSource`. The observers will be notified if a chip has been selected or unselected from the selected chip list in `ChipDataSource`. Both selection and deselection events will afford the chip that was selected or deselected respectively.

To use this functionality, you'll want to implement the `ChipDataSource.SelectionObserver` and register it on `ChipDataSource`. Be sure to manage unregistering the observer, if need be, as well. 

To set the observer, you'll need to call the `addSelectionObserver(ChipDataSource.SelectionObserver)` method in `ChipsInputLayout`.

Here is a simple example:
```java
public class CoolActivity extends AppCompatActivity implements ChipDataSource.SelectionObserver {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool);
        
        // Get the ChipsInputLayout from the layout file
        ChipsInputLayout chipsInput = (ChipsInputLayout)findViewById(R.id.chips);
        chipsInput.addSelectionObserver(this);
    }
    
    @Override
    public void onChipSelected(Chip selectedChip) {
        // Cool chip selection stuff here...
    }
    
    @Override
    public void onChipUnselected(Chip unselectedChip) {
        // Cool chip unselection stuff here...
    }
}
```

### Observing any change to the chip data source
`ChipDataSource` has the ability to notify observers that want to observe any type of change to the data in `ChipDataSource`. The observers will be notified if a chip has been added or removed from either the selected or filtered lists in the `ChipDataSource`; however, there's no information about the event though. 

This is used internally by the library to trigger UI updates on `RecyclerView` adapters when the data has changed.

To use this functionality, you'll want to implement the `ChipDataSource.ChangeObserver` and register it on `ChipDataSource`. Be sure to manage unregistering the observer, if need be, as well. 

To set the observer, you'll need to call the `addChangeObserver(ChipDataSource.ChangeObserver)` method in `ChipsInputLayout`.

Here is a simple example:
```java
public class CoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ChipDataSouce.ChangeObserver {
    public CoolAdapter(ChipDataSource dataSource) {
        dataSource.addChangeObserver(this);
    }
    
    // adapter implementation to do really cool adapter stuff...
    
    @Override
    public void onChipDataSourceChanged() {
        // This example would just update the Recycler when the chip data source changes
        notifyDataSetChanged();
    }
}
```

## Using Image Loading Libraries (Glide, Picasso,...)
This library affords the ability to use custom image rendering so that you can use any 3rd-party image loading libraries that you wish. `ChipImageRenderer` is provided to the library components to use when they need to load chip avatars. 

By default, `ChipsInputLayout` will use its own implementation of `ChipImageRenderer`, but you can provide a custom implementation to use instead by calling `setImageRenderer(ChipImageRenderer)` in `ChipsInputLayout`.

Here's a small example (using Glide):
```java
public class GlideRenderer implements ChipImageRenderer {
    @Override
    public void renderAvatar(ImageView imageView, Chip chip) {
        if (chip.getAvatarUri() != null) {
            // Use Glide to load URL (provided in avatar uri)
            Glide.with(imageView.getContext())
                    .load(chip.getAvatarUri())
                    .into(imageView);
        } else {
            // Default to circular tile if no uri exists
            imageView.setImageBitmap(LetterTileProvider
                    .getInstance(imageView.getContext())
                    .getLetterTile(chip.getTitle()));
        }
    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cool);
    
    // Find out chips input layout in xml layout
    ChipsInputLayout chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
    
    // Set the custom image renderer for chip avatars
    chipsInput.setImageRenderer(new GlideRenderer());
}
```

## Chip Validation
This library also affords the ability to validate chips. Chip validtion can be used for a plethora of reasons or use-cases. Validation can be done on the selected chips or on a single chip itself.

Validation is abstracted by the `ChipValidator` interface. This allows you to provide your own implementation of chip validation for whatever purpose you want or need it for. By default, there is no implementation of `ChipValidator` set or provided by this library.

### Creating a chip validator
`ChipValidator` must be implemented in order to write your own chip validation logic. `ChipValidator` has one method only, `validate(Chip)`, and it is used to determine when a single given chip should be considered valid.

Here's a small example:
```java
public class CustomChipValidator implements ChipsInputLayout.ChipValidator {
    @Override
    public boolean validate(Chip chip) {
        // This example will make the chip valid if the chip's title contains the letter "T"
        return chip.getTitle().toLowerCase().contains("t");
    }
}
```

### Setting a chip validator
A custom implementation of `ChipValidator` can be set using the `ChipsInputLayout`. Simply call the `setChipValidator(ChipValidator)` method in `ChipsInputLayout`.

Here's a simple example:
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cool);
    
    // Find out chips input layout in xml layout
    ChipsInputLayout chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
    
    // Set an instance of chip validator in chips input layout
    chipsInput.setChipValidator(new MyCoolChipValidator());
}
```

### Using a chip validator
Using a chip validator is really easy! After setting a chip validator in `ChipsInputLayout`, you can validate a single given chip or all the selected chips. 

Validating a single given chip can be done by calling, `validateChip(Chip)`, in `ChipsInputLayout`. Validating all the selected chips can be done by calling, `validateSelectedChips()`, in `ChipsInputLayout`. When you call either of those methods without having set a chip validator, it will simply return true.

Here's a simple example:
```java
public class CoolActivity extends AppCompatActivity {
    private ChipsInputLayout chipsInput;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool);
        
        // Find chips input layout in XML layout
        this.chipsInput = (ChipsInputLayout)findViewById(R.id.chips_input);
        
        // Set custom chip validator
        this.chipsInput.setChipValidator(new MyCoolChipValidator());
    }
    
    public void onCoolButtonClicked(View v) {
        // Example to show selected chip validation
        if (chipsInput.validateSelectedChips()) {
            Toast.makeText(this, "Selected chips are valid!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Selected chips are NOT valid!", Toast.LENGTH_SHORT).show();
        }
    }
}
```
