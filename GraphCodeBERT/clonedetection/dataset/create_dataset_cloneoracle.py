import os
import json

def read_file_content(file_path):
    with open(file_path, 'r') as file:
        content = file.read()
    return content

def read_files_from_folder(folder_path):
    all_code_files = []
    for root, dirs, files in os.walk(folder_path):
        print(root)
        for file in files:
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path) and file_path.endswith('.c'):
                print(file_path)
                id = file_path.split('/')[-2] + '/' + file_path.split('/')[-1]
                all_code_files.append([id, read_file_content(file_path)])
    return all_code_files

def write_to_jsonl(file_path, data):
    with open(file_path, 'w') as f:
        for item in data:
            f.write(json.dumps({'func': item[1], 'idx': item[0]}))
            f.write('\n')

def write_ocd_groundtruht(input, output):
    print(input)
    truth = read_file_content(input)
    with open(output, 'w') as f:
        for tline in truth.split('\n'):
            print(tline.split(','))
            tcolumn = tline.split(',')
            o = ''
            if tcolumn[0] == 'F':
                o = tcolumn[1] + '\t' + tcolumn[2] + '\t0\n'
            elif tcolumn[0] == 'T':
                o = tcolumn[1] + '\t' + tcolumn[2] + '\t1\n'
            f.write(o)
            
        
# Main execution
project_path = '/Users/chaiyong/Downloads/do_not_delete/SimilBench'
folder_path = 'data/cloneoracle/'
code_files_list = read_files_from_folder(project_path + '/' + folder_path)
write_to_jsonl(project_path + '/cloneoracle.jsonl', code_files_list)
write_ocd_groundtruht(project_path + '/truth/cloneoracle.csv', project_path + '/cloneoracle.txt')