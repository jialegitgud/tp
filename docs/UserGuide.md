---
layout: page
title: User Guide
---

Supply Central is a **desktop app for managing suppliers, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, SupplyCentral can get your supplier management tasks done faster than traditional GUI apps. This app is based on the Address Book 3 (AB3) project.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.

1. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/old-Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 a/John street, block 123, #01-01` : Adds a supplier named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the provided command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a supplier: `add`

Adds a supplier to the address book.

Format: `add n/NAME p/PHONE_NUMBER a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend a/Newgate Prison p/1234567 t/criminal`

### Listing all suppliers : `list`

Shows a list of all suppliers in the address book.

Format: `list`

### Editing a supplier : `edit`

Edits an existing supplier in the address book.

Format: `edit NAME [n/NEW_NAME] [p/PHONE] [a/ADDRESS] [t/TAG]…​`

* Edits the supplier with the specified `NAME`.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the supplier will be removed i.e adding of tags is not cumulative.
* You can remove all the supplier’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit John Doe p/91234567 e/johndoe@example.com` Edits the phone number and email address of the supplier (with name `John Doe`) to be `91234567` and `johndoe@example.com` respectively.
*  `edit Bety n/Betsy Crower t/` Edits the name of `Bety` to be `Betsy Crower` and clears all existing tags.

### Locating suppliers by name: `find`

Finds suppliers whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS] [c/CATEGORY]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* The keyword will be search on the name of the supplier.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* Optionally, one of the category "CONSUMABLES", "LIFESTYLE", "SPECIALTY" can be specified to search for suppliers which has goods which has the specified category. If the category is specified, the keywords are optional.

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)
* `find alex c/LIFESTYLE`
* `find c/CONSUMABLES`

### Deleting a supplier : `delete`

Deletes the specified supplier from the address book.

Format: `delete NAME`

* Deletes the person with the specified `NAME`.

Examples:
* `delete Amy` deletes the supplier of name `Amy` in the address book.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Adding of Goods : `goods`

To be added.

### Deletion of Goods : `delgoods`

To be added.

### View statistics for Goods : `view`

To be added.

### Export Goods Data to CSV: `export`

To be added.

### Saving the data

Supply Central data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

SupplyCentral data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, SupplyCentral will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause SupplyCentral to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete NAME`<br> e.g., `delete Amy`
**Edit** | `edit NAME [n/NEW_NAME] [p/PHONE_NUMBER] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit James n/James Lee`
**Find** | `find KEYWORD [MORE_KEYWORDS] [c/CATEGORY]`<br> e.g., `find James Jake c/CONSUMABLES`
**List** | `list`
**Help** | `help`
**Add Goods** | `goods`
**Delete Goods** | `delgoods`
**View Statistics** | `view`
**Export Data** | `export`
