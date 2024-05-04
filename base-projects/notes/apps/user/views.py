from django.contrib.auth import authenticate, login
from django.http import JsonResponse
from django.shortcuts import get_object_or_404
from django.views.decorators.csrf import csrf_exempt

from .models import CustomUser
from .forms import UserCreateForm


@csrf_exempt
def login_func(request):
    username = request.POST.get('username')
    password = request.POST.get('password')
    user = authenticate(request, username=username, password=password)
    if user is not None:
        login(request, user)
        return JsonResponse({'message': 'Login successful'})
    else:
        return JsonResponse({'error': 'Invalid username or password'}, status=400)


def user_list(request):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    users = CustomUser.objects.all()
    data = [{'id': user.id, 'username': user.username} for user in users]
    return JsonResponse(data, safe=False)


def user_me(request, pk):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    user: CustomUser = request.user
    data = {'id': user.id, 'username': user.username}
    return JsonResponse(data)


@csrf_exempt
def user_create(request):
    if request.method != 'POST':
        return JsonResponse({'error': "POST method required"})

    form = UserCreateForm(request.POST)
    if form.is_valid():
        user = form.save()
        data = {'id': user.id, 'username': user.username}
        return JsonResponse(data)
    else:
        return JsonResponse({'error': 'Invalid data'}, status=400)


def user_delete(request, pk):
    if not request.user.is_authenticated:
        return JsonResponse({'message': "User is not logged in"})

    user = get_object_or_404(CustomUser, pk=pk)
    user.delete()
    return JsonResponse({'message': 'User deleted successfully'})
