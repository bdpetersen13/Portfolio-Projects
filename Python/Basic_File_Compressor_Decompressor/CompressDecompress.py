import zlib
import base64


def compress(inputfile, outputfile):
    #Opening file to compress in read mode
    data = open(inputfile, 'r').read()
    #Converting file from str to bytes and then encoding & compressing the file
    dataBytes = bytes(data, 'utf-8')
    dataCompressed = base64.b64encode(zlib.compress(dataBytes, 9))

    #Changing data from bytes to string and then writing compressed data to new file
    dataDecoded = dataCompressed.decode('utf-8')

    compressedFile = open(outputfile, 'w')
    compressedFile.write(dataDecoded)


def decompress(inputfile, outputfile):
    fileContents = open(inputfile, 'r').read()
    dataEncoded = fileContents.encode('utf-8')

    #Decoding and decompressing the compressed text file
    dataDecompressed = zlib.decompress(base64.b64decode(dataEncoded))
    dataDecoded = dataDecompressed.decode('utf-8')

    file = open(outputfile, 'w')
    file.write(dataDecoded)

    file.close()
