o#Items the player can find in chest throughout the dungeon
#Items set to 0. When obatined set to 1
helmet = 0
dagger = 0
shield = 0
armor = 0
great_sword = 0
flare_gun = 0
treasure_key = 0
loot_key = 0

#Defining the game over feature. Allowing player to try again
#When the player dies this message will appear
def game_over():
    print("\n GAME OVER!")
    print("\n Do you wish to play again?")

    answer = input(">>>").lower()

    if 'y' in answer:
        start()
    else:
        exit()

#Defines the fight between the player and the cyclops
def cyclops_fight():
    print("\n The cyclops is standing in front of you!")
    print("\n It's at least 8ft tall")
    print("\n The cyclops begins a swing motion with his club!")
    print("\n What do you want to do? Do you want to dodge or block?")

    answer = input(">>>").lower()

    if 'd' in answer:
        print("\n The cyclops is open!")
        print("\n Do you want to attack?")

        answer = input(">>>").lower()

        if 'y' and great_sword == 1:
            print("\n You run up to the Cyclops after it missing striking you and stab it in the abdomen!")
            print("\n The Cyclops lets out a terrifying scream!")
            print("\n It takes a few steps back and then charges at you!")
            print("\n Do you stand in fight or dodge?")

            answer = input(">>>").lower()

            if 'f' and flare_gun == 1 in answer:
                print("\n You use your flare_gun and blind the Cyclops!")
                print("\n While blinded you charge and stab it again in the abdomen!")
                print("\n The Cyclops collapses to the ground!")
                print("\n Congragulations! You killed the Cyclops!")
                print("\n The treasures are yours now!")
            if 'f' and flare_gun == 0 in answer:
                print("\n The Cyclops strikes you down with the club!")
                game_over()
            if 'd' in answer:
                print("\n You failed to dodge!")
                print("\n The Cyclops stricked you down!")
                game_over()
        if 'y' and great_sword == 0:
            print("\n You run up to the Cyclops after missing stricking you")
            print("\n As you reach teh Cyclops, it picks you up with its free hand and slams you into the ground!")
            print("\n Unable to move the Cyclops repeatedly stricks you with the club!")
            game_over()
        else:
            print("\n The Cyclops rushes you!")
            print("\n It smacks you into the wall with its body!")
            print("\n Your armor is broken and your weapon is somewhere in the treasure room!")
            armor = 0
            dagger = 0
            great_sword = 0
            print("\n The Cyclops stands in front of you")
            print("\n What do you want to do?")
            print("\n Block the incoming swing or dodge?")

            answer = input(">>>").lower()

            if 'b' in answer:
                print("\n You block the strick from the Cyclops")
                print("\n The force from the strick smashes you into the wall")
                print("\n You fall to the ground and the Cyclops begins striking you repeatedly")
                game_over()
            if 'd' in answer:
                print("\n You're too injured to dodge!")
                print("\n The Cyclops strikes you!")
                game_over()
    if 'b' in answer:
        print("\n The force from the strike slams you into the treasure room's door!")
        print("\n Unable to recover from teh strike the Cyclops rushes you and kills you")
        game_over()

#defining the center treasure room
def center_treasure_room():
    print("\n As you approach the center of the treasure room you notice a giant cyclops sleeping in the corner!")
    print("\n As you start to back away slowly you knock over a pile of gold bricks")
    print("\n You just woke the cyclops up!")
    print("\n The cyclops picks up its large club and  is coming towards you!")
    print("\n You need to prepare to fight!")
    print("\n Are you ready?")

    answer = input(">>>").lower()

    if 'y' in answer:
        cyclops_fight()
    else:
        print("\n The cyclops ran and attacked you before you could do anything!")
        game_over()

#Defining the treasure room
def treasure_room():
    print("\n The light is so intense as you walk into the room it takes a few minutes to adjust!")
    print("\n Once adjusted you noticed piles of gold coin and brick everywhere!")
    print("\n You are speechless to the sight you're seeing")
    print("\n Do you wish to enter further into the room?")

    answer = input(">>>").lower()

    if 'y' in answer:
        center_treasure_room()
    elif 'n' in answer:
        south_dungeon()

#Defining the south dungeon
def south_dungeon():
    print("\n There are more tremors!")
    print("\n There's another wave of teh howling screams!")
    print("\n Once both the tremors and screams are done you stand up and look around the room")
    print("\n The first thing you notice is a doorway directly on the other side of the room")
    print("\n It's a giant door way. It's covered in gold and precious jewels")
    print("\n As you make you're way to teh door you notice there's a small chest in teh corner")

    print("Do you wish to search the chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        print("There was nothing in the chest")
    elif 'n' in answer:
        print("Who has the time for a chest when there's a door like this! This must lead to the treasure room!")

    print("Do you want to open teh door?")

    answer = input(">>>").lower()

    if 'y' in answer and treasure_key == 1:
        print("\n You take out the matching key and place it into the lock")
        print("\n You slowly turn the key. Hearing all teh mechanisms line up")
        print("\n As you slowly open the door you begin to be blinded by a bright light")

        treasure_room()

    elif 'y' in answer and treasure_key == 0:
        print("\n The door is locked! We have to find the key!")

        vast_room()

    elif 'n' in answer:
        print("\n We should continue looking around the dungeon for other items and valuables!")
        print("\n Do you want to head back north?")

        if 'y' in answer:
            vast_room()
        elif 'n' in answer:
            print("\n You just sat there in the dungeon. AS if you were waiting for the door to open itself")

            game_over()

#Defining east dungeon
def east_dungeon():
    print("\n As you enter the room you hear a loud deep howling scream!")
    print("\n The sound has so terrified that you're frozen in place for a few minutes")
    print("\n When you finally work the courage to move and search the room")
    print("\n You notice the door behind you has collapsed in and there's only one door way heading west")
    print("\n As you head towards the door way you notice on small chest")
    print("\n Do you want to open the chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        print("You found a flare gun with flares!")
        flare_gun = 1
    elif 'n' in answer:
        print("\n Let's just get out of the room!")

    print("\n Do you want to go through the west door way?")

    answer = input(">>>").lower()

    if 'y' in answer:
        vast_room()
    elif 'n' in answer:
        print("\n You attempted to move the rocks from the door way you entered")
        print("\n This caused a cave in, crushing you to death!")

        game_over()

#Definging center east dungeon
def center_east_dungeon():
    print("\n As you enter the room you notice the room looks like it will collapse at anytime")
    print("\n As you head further into the room the door way back to the northeast collapses!")
    print("\n This sends a wave of fear through your body")
    print("\n Near the south door way you see two chest")
    print("\n Do you want to search the first chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        treasure_key = 1
        print("\n You found a massive key! The key is made of solid gold with many precious jewels!")
        print("\n This key must be used for hte treasure room!")
    elif 'n' in answer:
        print("\n The room collapsed killing you!")
        game_over()

    print("\n Do you want to search the second chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        print("\n The chest was booby trapped! A bomb exploded, killing you!")
        game_over()
    elif 'n' in answer:
        print("\n Good idea! Looks like the room is about to collapse any minute now!")

    print("\n Do you want to head south?")

    answer = input(">>>").lower()

    if 'y' or 's' in answer:
        east_dungeon()
    else:
        print("\n The room collapsed, killing you!")
        game_over()

#Defining the northeast dungeon
def northeast_dungeon():
    print("\n As you enter the dungeon there is a large tremor")
    print("\n The tremor forces you onto your knees")
    print("\n As the tremors finish a chest falls from the ceiling!")
    print("\n The chest is the only item in the room and there's one door way heading south")
    print("\n Do you want to search the chest")

    answer = input(">>>").lower()

    if 'y' in answer and loot_key == 1:
        print("\n You use the key you found earlier to unlock the chest")
        print("\n The chest is difficult to open, but you manage to pry it open")
        print("\n Nothing! There's absolutely nothing in the chest!")
        print("\n As you try to remove the key from the chest is snaps into two")
        loot_key = 0
    elif 'y' in answer and loot_key == 0:
        print("\n The chest is locked and requires a key!")
    elif 'n' in answer:
        print("Weird tremor and a chest falling?! Something strange is happening here!")

    print("\n Do you wish to head south or go back through the west door way?")

    answer = input(">>>").lower()

    if 's' in answer:
        center_east_dungeon()
    elif 'w' in answer:
        north_dungeon()

#defining the north dungeon
def north_dungeon():
    print("\n As you enter the dungeon you get a strange feeling of being watched")
    print("\n As you search the room looking for the cause you see a door way to the east")
    print("\n You also notice a chest in the center of the room")
    print("\n Do you want to search the chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        loot_key = 1
        armor = 1
        print("\n You found a very small key! It looks like it could fit a chest!")
        print("\n You found armor! This will be helpful if you have to face off against any enemies")

    print("\n Do you want to go through the east door way or back through the south door way?")

    answer = input(">>>").lower()

    if 'e' in answer:
        northeast_dungeon()
    elif 's' in answer:
        vast_room()

#Defining the vast room
def vast_room():
    print("\n As you enter the vast room you hear a loud sound coming from behind you!")
    print("\n When you turn around you see the room behind you has collapsed!")
    print("\n In this room you see two chest!")
    print("\n You also take notice of three door ways. One to the north, east, and south")
    print("\n Do you want to search the chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        shield = 1
        print("You found a shield!")
    elif 'n' in answer:
        print("Ever so brave!")

    print("\n Do you want to search the second chest?")

    answer = input(">>>").lower()

    if 'y' in answer and loot_key == 1:
        great_sword = 1
        print("\n You found a great sword!")
    elif 'y' in answer and loot_key == 0:
        print("\n This chest requires a key to unlock it!")
    elif 'n' in answer:
        print("\n The chest looks strange. Good idea to pass on it!")

    print("\n Which direction do you want to move. North? East? or South?")

    answer = input(">>>").lower()

    if 'n' in answer:
        north_dungeon()
    elif 'e' in answer:
        east_dungeon()
    elif 's' in answer:
        south_dungeon()

#Defining the room you wake up in
def wake_up_room():
    print("\n You wake up in a strange dark room. It seems that you're in  a  giant underground dungeon")
    print("\n As you begin looking around the room you notice a single door way and a single chest")
    print("\n Do you want to search the chest?")

    answer = input(">>>").lower()

    if 'y' in answer:
        helmet = 1
        dagger = 1
        print("\n You found a helmet and a dagger!")
    elif 'n' in answer:
        print("You seem very brave, but also very stupid")

    print("\n Do you wish to proceed through the door way?")

    answer = input(">>>").lower()

    if 'y' in answer:
        vast_room()
    elif 'n' in answer:
        print("The room collapsed, killing you!")
        game_over()

#Defining how the game starts
def start():
    wake_up_room()

#Starting the game
start()
