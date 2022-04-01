#Importing necessary libraries and modules
import tkinter
from tkinter import filedialog
from CompressDecompress import compress
from CompressDecompress import decompress

#File for selecting a file in file directory
def openFile():
    fileName = filedialog.askopenfilename(initialdir='/',title="Please Select A File to Compress")

    return fileName

#Functions for compressing and decompressing files
def compression(inputfile, outputfile):
    compress(inputfile, outputfile)

def decompression(inputfile, outputfile):
    decompress(inputfile, outputfile)

#Creating window and giving it a setTitle and Size for the window
window = tkinter.Tk()
window.title("File Compression Application")
window.geometry("800x400")
window.resizable(False, False)

#Input and output widgets for selecting input and output files to compress
compressInputEntry = tkinter.Entry(window)
compressOutputEntry = tkinter.Entry(window)

compressInputLabel = tkinter.Label(window, text="Input File to Compress")
compressOutputLabel = tkinter.Label(window, text="Name of Compressed File")

#Creating widget for compressing selected files by using a lambda function to get the real time values of input and output field
compressButton = tkinter.Button(window, text="Compress File", command=lambda:compression(compressInputEntry.get(), compressOutputEntry.get()))

#Displaying widgets in the window
compressInputEntry.grid(row=0, column=1)
compressInputLabel.grid(row=0, column=0)
compressOutputEntry.grid(row=1, column=1)
compressOutputLabel.grid(row=1, column=0)
compressButton.grid(row=2, column=1)

#Creating a Search widget to search for file to compress if application is not already in the needed file directory
compressSearchButton = tkinter.Button(window, text="Search", command=lambda:compression(openFile(), "compressedoutputfile.txt"))
compressSearchButton.grid(row=2, column=2)

#Creating blank widget to provide spacing between compress and decompress functionality
blankWindowField1 = tkinter.Label(window, text="")
blankWindowField1.grid(row=3, column=0)
blankWindowField2 = tkinter.Label(window, text="")
blankWindowField2.grid(row=4, column=0)

#Input and output widgets for selecting input and output files to decompress
decompressInputEntry = tkinter.Entry(window)
decompressOutputEntry = tkinter.Entry(window)
decompressInputLabel = tkinter.Label(window, text="Input File to Decompress")
decompressOutputLabel = tkinter.Label(window, text="Name of Decompressed File")

#Creating widget for compressing selected files by using a lambda function to get the real time values of input and output field
decompressButton = tkinter.Button(window, text="Decompress File", command=lambda:decompression(decompressInputEntry.get(), decompressOutputEntry.get()))

#Creating a Search widget to search for file to decompress if application is not already in the needed file directory
decompressSearchButton = tkinter.Button(window, text="Search", command=lambda:decompression(openFile(), "decompressOutputFile.txt"))
decompressSearchButton.grid(row=7, column=2)

#Displaying widgets in the window
decompressInputEntry.grid(row=5, column=1)
decompressInputLabel.grid(row=5, column=0)
decompressOutputEntry.grid(row=6, column=1)
decompressOutputLabel.grid(row=6, column=0)
decompressButton.grid(row=7, column=1)


window.mainloop()
