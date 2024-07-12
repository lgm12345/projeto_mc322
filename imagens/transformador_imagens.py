from PIL import Image

def invert_colors_near_threshold(image_path, output_path, threshold=30):
    # Abre a imagem
    image = Image.open(image_path)
    
    # Converte a imagem para modo RGB, se não já estiver
    image = image.convert('RGB')
    
    # Carrega os dados da imagem
    pixels = image.load()
    
    # Obtém as dimensões da imagem
    width, height = image.size
    
    # Função para determinar se uma cor está próxima do branco ou preto
    def is_near_white(r, g, b, threshold):
        return r >= 255 - threshold and g >= 255 - threshold and b >= 255 - threshold
    
    def is_near_black(r, g, b, threshold):
        return r <= threshold and g <= threshold and b <= threshold
    
    # Percorre cada pixel da imagem
    for x in range(width):
        for y in range(height):
            r, g, b = pixels[x, y]
            
            # Verifica se o pixel é próximo do branco
            if is_near_white(r, g, b, threshold):
                # Muda o pixel para preto
                pixels[x, y] = (0, 0, 0)
            # Verifica se o pixel é próximo do preto
            elif is_near_black(r, g, b, threshold):
                # Muda o pixel para branco
                pixels[x, y] = (255, 255, 255)
    
    # Salva a imagem modificada
    image.save(output_path)

# Exemplo de uso
input_image_path = 'imagens/torre_preta_fundo_branco.jpeg'
output_image_path = 'imagens/imagem_modificada.jpeg'
invert_colors_near_threshold(input_image_path, output_image_path,35)
