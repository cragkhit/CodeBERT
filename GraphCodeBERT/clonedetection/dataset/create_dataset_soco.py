import os
import json

def read_file_content(file_path):
    with open(file_path, 'r') as file:
        content = file.read()
    return content

def read_files_from_folder(folder_path):
    count = 1
    all_code_files = []
    for root, dirs, files in os.walk(folder_path):
        # print(root)
        for file in files:
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path) and file_path.endswith('.java'):
                file_id = file_path.split('/')[-1].replace('.java','')
                print(file_id + ':' + file_path)
                all_code_files.append([file_id, read_file_content(file_path)])
                count+=1
    return all_code_files

def write_to_jsonl(file_path, data):
    with open(file_path, 'w') as f:
        for item in data:
            f.write('{"func": "    ' + item[1].replace('\n','\\n').replace('"','\\"') + '", "idx": "' + str(item[0]) + '"}\n')
    with open(file_path) as f:
        for line in f:
            print(line)

def read_soco_groundtruth(file_path):
    soco_groundtruth = [];
    with open(file_path, 'r') as f:
        lines = f.readlines()
    for line in lines:
        pair = set(line.replace('\n', '').split(' '))
        # print(pair)
        soco_groundtruth.append(pair)
    return soco_groundtruth

def is_in_groundtruth(i, j, groundtruth):
    for pair in groundtruth:
        if (str(i) in pair and str(j) in pair):
            return True
    return False

def write_soco_groundtruth(file_path, groundtruth):
    count_true_clone_pairs = 0
    with open(file_path, 'w') as f:
        for i in range(1, 260):
            for j in range(1, 260):
                i_str = "{:03d}".format(i)
                j_str = "{:03d}".format(j)
                if (is_in_groundtruth(i_str, j_str, groundtruth)):
                    print(i_str + ' ' + j_str + ' 1')
                    count_true_clone_pairs += 1
                    f.write(i_str + '\t' + j_str + '\t1\n')
                else:
                    f.write(i_str + '\t' + j_str + '\t0\n')
    print('count_true_clone_pairs: ' + str(count_true_clone_pairs))
        

# Main execution
project_path = '/Users/chaiyong/Downloads/BCBStudy/CodeBERT/GraphCodeBERT/clonedetection/dataset'
folder_path = 'soco/soco_f'
code_files_list = read_files_from_folder(project_path + '/' + folder_path)
write_to_jsonl(project_path + '/soco.jsonl', code_files_list)
groundtruth = read_soco_groundtruth(project_path + '/soco/soco_train_clones_fixed.txt')
# print(groundtruth)
write_soco_groundtruth(project_path + '/soco_test.txt', groundtruth)