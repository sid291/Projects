#include <stdio.h>
#include <string.h>

#define MAX_ROOMS 5 // Maximum number of rooms

// Structure to store information about a room
typedef struct {
    int room_number;
    char customer_name[50];
    int is_reserved; // 0 for not reserved, 1 for reserved
} Room;

// Function prototypes
void displayRooms(Room rooms[], int size);
void makeReservation(Room rooms[], int size);
void cancelReservation(Room rooms[], int size);
void viewReservations(Room rooms[], int size);

int main() {
    Room rooms[MAX_ROOMS] = {
        {101, "", 0}, {102, "", 0}, {103, "", 0},
        {104, "", 0}, {105, "", 0}
    };

    int choice;
    
    while (1) {
        // Display Menu
        printf("\n----- Hotel Reservation System -----\n");
        printf("1. Display Rooms\n");
        printf("2. Make a Reservation\n");
        printf("3. Cancel a Reservation\n");
        printf("4. View Reservations\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch (choice) {
            case 1:
                displayRooms(rooms, MAX_ROOMS);
                break;
            case 2:
                makeReservation(rooms, MAX_ROOMS);
                break;
            case 3:
                cancelReservation(rooms, MAX_ROOMS);
                break;
            case 4:
                viewReservations(rooms, MAX_ROOMS);
                break;
            case 5:
                printf("Thank you for visiting...\n");
                return 0;
            default:
                printf("Invalid choice, please try again.\n");
        }
    }

    return 0;
}

// Function to display available rooms
void displayRooms(Room rooms[], int size) {
    printf("\n----- Available Rooms -----\n");
    for (int i = 0; i < size; i++) {
        if (rooms[i].is_reserved == 0) {
            printf("Room Number: %d - Available\n", rooms[i].room_number);
        }
    }
}

// Function to make a reservation
void makeReservation(Room rooms[], int size) {
    int room_number;
    char name[50];
    int found = 0;

    printf("\nEnter Room Number to reserve: ");
    scanf("%d", &room_number);
    
    // Check if the room number is valid and available
    for (int i = 0; i < size; i++) {
        if (rooms[i].room_number == room_number && rooms[i].is_reserved == 0) {
            found = 1;
            printf("Enter your name: ");
            scanf(" %[^\n]", name);  // Read full name including spaces
            strcpy(rooms[i].customer_name, name);
            rooms[i].is_reserved = 1;
            printf("Room %d has been reserved for %s.\n", room_number, rooms[i].customer_name);
            break;
        }
    }
    
    if (!found) {
        printf("Room number %d is either invalid or already reserved.\n", room_number);
    }
}

// Function to cancel a reservation
void cancelReservation(Room rooms[], int size) {
    int room_number;
    int found = 0;

    printf("\nEnter Room Number to cancel reservation: ");
    scanf("%d", &room_number);
    
    // Check if the room number is valid and reserved
    for (int i = 0; i < size; i++) {
        if (rooms[i].room_number == room_number && rooms[i].is_reserved == 1) {
            found = 1;
            printf("Reservation for room %d by %s has been canceled.\n", room_number, rooms[i].customer_name);
            rooms[i].is_reserved = 0;
            rooms[i].customer_name[0] = '\0'; // Clear the customer name
            break;
        }
    }
    
    if (!found) {
        printf("Room number %d is either invalid or not reserved.\n", room_number);
    }
}

// Function to view all reservations
void viewReservations(Room rooms[], int size) {
    printf("\n----- Current Reservations -----\n");
    for (int i = 0; i < size; i++) {
        if (rooms[i].is_reserved == 1) {
            printf("Room Number: %d - Reserved by: %s\n", rooms[i].room_number, rooms[i].customer_name);
        }
    }
}
