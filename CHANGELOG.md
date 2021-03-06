# Changelog

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.5.3] - 2020-04-04
### Fixed
- Mobs no longer rapidly change max health.

## [2.5.2] - 2020-03-29
### Fixed
- Power crystals work again
- Hearts now sync properly on log in and on death

## [2.5.1] - 2020-03-28
### Fixed
- Config folders will now generate automatically, if absent.

## [2.5.0] - 2020-03-20
Major changes to config files. Save your current config in a text editor before updating!
Else you have to change it all again.
Tested a lot but not for long, backup your worlds! Especially if playing on a server.

These big changes are made to wrap up the 1.14.4 version of SH. Will not be adding any other features,
so should have a non-beta release soon (fixing bugs yay). 
Then onto 1.15.2, where I will reimplement (or at least try to) by dim configs.

#### Added
- The dimension configs are replaced by a unique game_settings.toml file. 
- The common config now has simple enable configs for the mods features.
- The game_settings config is basically an extension of the common config.
- The ore gen of both crystals can be disabled.
- Bandaged effect now has a texture.

#### Removed
- The config by dimension feature has been removed.
- The equipment configs have been removed.
- Unused or now unusable configs have been removed.

#### Tweaks
- The DIMENSION_WIDE option is now SERVER_WIDE. Lang and commands have been updated accordingly.

## [2.4.2] - 2020-03-05
### Added
- Pets will now accept heart crystals and it increases their hp. The amount is configurable.
### Fixed
- Being afk at max difficulty no longer displays a message (or does anything)

## [2.4.1] - 2020-02-25
### Added
- Key bind option to display the difficulty bar
- Blight chance config, also allowing blights to be deactivated
- Added config option for afk time, default is 2 minutes
### Fixed
- Change in difficulty from being afk now works properly

## [2.4.0] - 2020-02-21
- Updated to new stable forge version, 28.2.0
### Added
- New debug log option in the COMMON config, covers equipment entries
### Fixed
- Mob equipment should no longer crash

## [2.3.14] - 2020-02-09
### Added
- Kill mutators now work, a config option
### Fixed
- Ore texture's background is now the 1.14 stone texture instead of the old one
- Coming back from the End will no longer reset your stats.

## [2.3.13] - 2020-02-02
Friendly reminder to backup your worlds, had some weird crashes, shouldn't happen, but you never know
### Added
- Mobs will now be equipped with armor based on difficulty
- Pets will regen

## [2.3.12] - 2020-01-26
### Fixed
- Quick fix for server, particle registration was crashing (should fix at least)

## [2.3.11] - 2020-01-26
### Added
- Config option to deactivate the afk message
### Fixed
- Player exemption lists now works, beware however since it sets the difficulty to 0, it doesn't just stop it.
- Particles now work! Hooray! Not quite as fancy as I would like though, might work on them more in the future

## [2.3.10] - 2020-01-22
### Added
- Config for scaling bonus hp of mob spawned by spawners
- Blight Bosses have cool dark purple names
- New configs for bonus hp based on xp, can replace or add to current heart crystal sys
### Fixed
- Crashes occurring during getBlightChance


## [2.3.9] - 2020-01-15
### Added
- Config for changing heart crystal heart gain
- Config for blacklisting mods in damage scaling
### Fixed
- Xp client desync bug

## [2.3.8] - 2020-01-12
### Added
- Functionality for configs:
- ignoring y-axis during diff calcs
- blight diff modifier
- idle player diff modifier
- Mobs will now spawn with a difficulty of 95% to 105% of the area difficulty. (will add config options later)
### Fixed
- Sounds are back!

## [2.3.7] - 2020-01-10
### Added
- Power Crystal now has a texture!
- Scaling Health now has a creative tab

## [2.3.6] - 2020-01-09
### Fixed
- Blight's fire now render! Hooray!

## [2.3.5] - 2020-01-09
Mostly a debug update, trying to get things working
### Added
- Config options

## [2.3.4] - 2020-01-07
### Added
- Lucky Heart
- Blacklist mob config
- Explanation for the different difficulty types and mob hp configs
### Fixed
- Hearts lost on death
- Certain difficulty types now work properly

## [2.3.3] - 2019-10-06
### Added
- Config to disable heart tank icons

## [2.3.2] - 2019-09-10
### Fixed
- Peaceful mobs being identified as hostile (wrong effect chances)

## [Unreleased]
### Fixed
- Cursed heart and enchanted heart not appearing in creative menu or JEI [#191]

## [2.3.1] - 2019-08-06
- Updated for Forge 28.0.45
### Added
- New WIP HUD element, "heart tanks". This is a row of icons above your hearts which will display how many rows of hearts. No configs for this at the moment, just needed to get this update out.

## [2.3.0] - 2019-07-23
- Updated for 1.14.4

## [2.2.1] - 2019-07-15
### Fixed
- Player starting health not working [#180]
- Crash when dropping items
- Crash when joining a world
- Various other minor fixes

## [2.2.0] - 2019-07-03
Updated for 1.14.3
### Fixed
- Ore loot tables
- `scalinghealth:mob_properties` condition requiring both min and max difficulty (both are optional)

## [2.1.0]
Port to 1.14.2
Update zh_cn translation (XuyuEre)
### Added
- Sleep configs are back

## [2.0.4] - 2019-05-01
### Added
- Location multiplier configs. Allows difficulty to be increased/decreased in different dimensions and biomes.
- Lunar cycle configs are back

## [2.0.3] - 2019-04-12
### Added
- Blight potion configs (found in dimension config files)
- Player bonus regen configs
### Fixed
- Blight fires

## [2.0.2] - 2019-03-12
### Added
- `sh_summon` command - Summons entities with a given difficulty and blight status, along with everything the vanilla summon command offers.
### Fixed
- Maybe reduce the chance of capability-related crashes

## [2.0.1] - 2019-03-02
Disabled recipe and model generators... oops. You can delete the "output" folder in your ".minecraft" folder. Sorry about that.
### Added
- Russian translation (by Voknehzyr)
