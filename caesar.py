from tkinter import *

# Caesar Cipher function to encrypt a message with a given shift key
def caesar_cipher_encrypt(message, key):
    encrypted_message = ""
    for char in message:
        if char.isalpha():
            char_code = ord(char)
            char_code += key
            if char.isupper():
                if char_code > ord('Z'):
                    char_code -= 26
                elif char_code < ord('A'):
                    char_code += 26
            else:
                if char_code > ord('z'):
                    char_code -= 26
                elif char_code < ord('a'):
                    char_code += 26
            encrypted_message += chr(char_code)
        else:
            encrypted_message += char
    return encrypted_message

# Caesar Cipher function to decrypt an encrypted message with a given shift key
def caesar_cipher_decrypt(encrypted_message, key):
    decrypted_message = ""
    for char in encrypted_message:
        if char.isalpha():
            char_code = ord(char)
            char_code -= key
            if char.isupper():
                if char_code < ord('A'):
                    char_code += 26
                elif char_code > ord('Z'):
                    char_code -= 26
            else:
                if char_code < ord('a'):
                    char_code += 26
                elif char_code > ord('z'):
                    char_code -= 26
            decrypted_message += chr(char_code)
        else:
            decrypted_message += char
    return decrypted_message

# GUI initialization
root = Tk()
root.title("Caesar Cipher Encryption and Decryption")
root.geometry("600x400")

# Main frame
main_frame = Frame(root, padx=20, pady=20)
main_frame.pack(expand=True)

# Title label
title_label = Label(main_frame, text="Caesar Cipher Encryption and Decryption", font=("Arial", 18, "bold"), fg='red')
title_label.pack(pady=20)

# Message input label
msg_label = Label(main_frame,fg="green", text="Enter a message:")
msg_label.pack()

# Message input field
msg_entry = Entry(main_frame, width=30)
msg_entry.pack()

# Key selection label
key_label = Label(main_frame, bg="blue", text="Select a shift key (1-9):")
key_label.pack()

# Key selection dropdown menu
key_var = StringVar(root)
key_var.set("1") # default value
key_menu = OptionMenu(main_frame, key_var, "1", "2", "3", "4", "5", "6", "7", "8", "9")
key_menu.pack()

# Encryption function
def encrypt():
    message = msg_entry.get()
    key = int(key_var.get())
    encrypted_message = caesar_cipher_encrypt(message, key)
    result_label.config(text=encrypted_message)

# Decryption function
def decrypt():
    encrypted_message = msg_entry.get()
    key = int(key_var.get())
    decrypted_message = caesar_cipher_decrypt(encrypted_message, key)
    result_label.config(text=decrypted_message)

# Button frame
button_frame = Frame(main_frame)
button_frame.pack(pady=20)

# Encrypt button
encrypt_button = Button(button_frame, text="Encrypt",bg="green", font=("Arial", 14), command=encrypt)
encrypt_button.pack(side=LEFT, padx=10)

# Decrypt button
decrypt_button = Button(button_frame, text="Decrypt",bg="red", font=("Arial", 14), command=decrypt)
decrypt_button.pack(side=LEFT, padx=10)

# Result label
result_label = Label(main_frame,width=40, height= 30,bd=3, bg="white", text="", font=("Arial", 14))
result_label.pack()


root.mainloop()
